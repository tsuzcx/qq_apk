package org.xwalk.core.resource;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import org.xwalk.core.Log;

public class XWalkResource
  extends Resources
{
  public static final String TAG = "XWalkResource";
  private WeakReference<Context> mWeChatContext;
  
  public XWalkResource(Resources paramResources, Context paramContext)
  {
    super(paramResources.getAssets(), paramContext.getResources().getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(155344);
    this.mWeChatContext = new WeakReference(paramContext);
    AppMethodBeat.o(155344);
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    AppMethodBeat.i(155346);
    Object localObject = (Context)this.mWeChatContext.get();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getResources().getDisplayMetrics();
      AppMethodBeat.o(155346);
      return localObject;
    }
    localObject = super.getDisplayMetrics();
    AppMethodBeat.o(155346);
    return localObject;
  }
  
  public void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(187698);
    Log.i("XWalkResource", "updateConfiguration, locale:" + paramConfiguration.locale);
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    AppMethodBeat.o(187698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkResource
 * JD-Core Version:    0.7.0.1
 */