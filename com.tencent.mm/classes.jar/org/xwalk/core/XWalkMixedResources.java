package org.xwalk.core;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

class XWalkMixedResources
  extends Resources
{
  private Resources mLibraryResource;
  
  XWalkMixedResources(Resources paramResources1, Resources paramResources2)
  {
    super(paramResources1.getAssets(), paramResources1.getDisplayMetrics(), paramResources1.getConfiguration());
    AppMethodBeat.i(154798);
    this.mLibraryResource = paramResources2;
    AppMethodBeat.o(154798);
  }
  
  private boolean isCalledInLibrary()
  {
    AppMethodBeat.i(154797);
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfStackTraceElement[i].getClassName();
      if ((str.startsWith("org.chromium")) || (str.startsWith("org.xwalk.core.internal")))
      {
        AppMethodBeat.o(154797);
        return true;
      }
      if ((str.startsWith("org.xwalk.core")) && (!str.endsWith("XWalkMixedResources")))
      {
        AppMethodBeat.o(154797);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(154797);
    return false;
  }
  
  public Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(154804);
    bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      localDrawable1 = this.mLibraryResource.getDrawable(paramInt);
      AppMethodBeat.o(154804);
      return localDrawable1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Drawable localDrawable1;
      if (!bool) {
        break label61;
      }
      Drawable localDrawable2 = super.getDrawable(paramInt);
      AppMethodBeat.o(154804);
      return localDrawable2;
      localDrawable2 = this.mLibraryResource.getDrawable(paramInt);
      AppMethodBeat.o(154804);
      return localDrawable2;
    }
    localDrawable1 = super.getDrawable(paramInt);
    AppMethodBeat.o(154804);
    return localDrawable1;
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(154803);
    if (isCalledInLibrary())
    {
      i = this.mLibraryResource.getIdentifier(paramString1, paramString2, paramString3);
      if (i != 0)
      {
        AppMethodBeat.o(154803);
        return i;
      }
      i = super.getIdentifier(paramString1, paramString2, paramString3);
      AppMethodBeat.o(154803);
      return i;
    }
    int i = super.getIdentifier(paramString1, paramString2, paramString3);
    if (i != 0)
    {
      AppMethodBeat.o(154803);
      return i;
    }
    i = this.mLibraryResource.getIdentifier(paramString1, paramString2, paramString3);
    AppMethodBeat.o(154803);
    return i;
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    AppMethodBeat.i(154800);
    bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      localXmlResourceParser1 = this.mLibraryResource.getLayout(paramInt);
      AppMethodBeat.o(154800);
      return localXmlResourceParser1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      XmlResourceParser localXmlResourceParser1;
      if (!bool) {
        break label61;
      }
      XmlResourceParser localXmlResourceParser2 = super.getLayout(paramInt);
      AppMethodBeat.o(154800);
      return localXmlResourceParser2;
      localXmlResourceParser2 = this.mLibraryResource.getLayout(paramInt);
      AppMethodBeat.o(154800);
      return localXmlResourceParser2;
    }
    localXmlResourceParser1 = super.getLayout(paramInt);
    AppMethodBeat.o(154800);
    return localXmlResourceParser1;
  }
  
  public CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(154799);
    bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      localCharSequence1 = this.mLibraryResource.getText(paramInt);
      AppMethodBeat.o(154799);
      return localCharSequence1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      CharSequence localCharSequence1;
      if (!bool) {
        break label61;
      }
      CharSequence localCharSequence2 = super.getText(paramInt);
      AppMethodBeat.o(154799);
      return localCharSequence2;
      localCharSequence2 = this.mLibraryResource.getText(paramInt);
      AppMethodBeat.o(154799);
      return localCharSequence2;
    }
    localCharSequence1 = super.getText(paramInt);
    AppMethodBeat.o(154799);
    return localCharSequence1;
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(154801);
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      this.mLibraryResource.getValue(paramInt, paramTypedValue, paramBoolean);
      AppMethodBeat.o(154801);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (!bool) {
        break label65;
      }
      super.getValue(paramInt, paramTypedValue, paramBoolean);
      AppMethodBeat.o(154801);
      return;
      label65:
      this.mLibraryResource.getValue(paramInt, paramTypedValue, paramBoolean);
      AppMethodBeat.o(154801);
    }
    super.getValue(paramInt, paramTypedValue, paramBoolean);
    AppMethodBeat.o(154801);
    return;
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    AppMethodBeat.i(154802);
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      this.mLibraryResource.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
      AppMethodBeat.o(154802);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (!bool) {
        break label71;
      }
      super.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
      AppMethodBeat.o(154802);
      return;
      label71:
      this.mLibraryResource.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
      AppMethodBeat.o(154802);
    }
    super.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    AppMethodBeat.o(154802);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkMixedResources
 * JD-Core Version:    0.7.0.1
 */