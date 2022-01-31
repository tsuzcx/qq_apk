package org.xwalk.core;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

class XWalkMixedResources
  extends Resources
{
  private Resources mLibraryResource;
  
  XWalkMixedResources(Resources paramResources1, Resources paramResources2)
  {
    super(paramResources1.getAssets(), paramResources1.getDisplayMetrics(), paramResources1.getConfiguration());
    this.mLibraryResource = paramResources2;
  }
  
  private boolean isCalledInLibrary()
  {
    boolean bool2 = false;
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      String str;
      if (i < j)
      {
        str = arrayOfStackTraceElement[i].getClassName();
        if ((!str.startsWith("org.chromium")) && (!str.startsWith("org.xwalk.core.internal"))) {
          break label58;
        }
        bool1 = true;
      }
      label58:
      do
      {
        return bool1;
        if (!str.startsWith("org.xwalk.core")) {
          break;
        }
        bool1 = bool2;
      } while (!str.endsWith("XWalkMixedResources"));
      i += 1;
    }
  }
  
  public Drawable getDrawable(int paramInt)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      return this.mLibraryResource.getDrawable(paramInt);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Drawable localDrawable;
      if (!bool) {
        break label37;
      }
      return super.getDrawable(paramInt);
    }
    localDrawable = super.getDrawable(paramInt);
    return localDrawable;
    label37:
    return this.mLibraryResource.getDrawable(paramInt);
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    int i;
    if (isCalledInLibrary())
    {
      i = this.mLibraryResource.getIdentifier(paramString1, paramString2, paramString3);
      if (i == 0) {}
    }
    int j;
    do
    {
      return i;
      return super.getIdentifier(paramString1, paramString2, paramString3);
      j = super.getIdentifier(paramString1, paramString2, paramString3);
      i = j;
    } while (j != 0);
    return this.mLibraryResource.getIdentifier(paramString1, paramString2, paramString3);
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      return this.mLibraryResource.getLayout(paramInt);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      XmlResourceParser localXmlResourceParser;
      if (!bool) {
        break label37;
      }
      return super.getLayout(paramInt);
    }
    localXmlResourceParser = super.getLayout(paramInt);
    return localXmlResourceParser;
    label37:
    return this.mLibraryResource.getLayout(paramInt);
  }
  
  public CharSequence getText(int paramInt)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      return this.mLibraryResource.getText(paramInt);
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      CharSequence localCharSequence;
      if (!bool) {
        break label37;
      }
      return super.getText(paramInt);
    }
    localCharSequence = super.getText(paramInt);
    return localCharSequence;
    label37:
    return this.mLibraryResource.getText(paramInt);
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      this.mLibraryResource.getValue(paramInt, paramTypedValue, paramBoolean);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (!bool) {
        break label45;
      }
      super.getValue(paramInt, paramTypedValue, paramBoolean);
      return;
      label45:
      this.mLibraryResource.getValue(paramInt, paramTypedValue, paramBoolean);
    }
    super.getValue(paramInt, paramTypedValue, paramBoolean);
    return;
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    boolean bool = isCalledInLibrary();
    if (bool) {}
    try
    {
      this.mLibraryResource.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (!bool) {
        break label51;
      }
      super.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
      return;
      label51:
      this.mLibraryResource.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    }
    super.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkMixedResources
 * JD-Core Version:    0.7.0.1
 */