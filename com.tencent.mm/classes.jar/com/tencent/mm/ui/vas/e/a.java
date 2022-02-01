package com.tencent.mm.ui.vas.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/result/ActivityResultHolder;", "", "()V", "hasActivityResult", "", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "resultCode", "getResultCode", "setResultCode", "resultData", "Landroid/content/Intent;", "getResultData", "()Landroid/content/Intent;", "setResultData", "(Landroid/content/Intent;)V", "get", "Lkotlin/Triple;", "reset", "", "set", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static Intent Ofj;
  public static final a afRq;
  public static boolean afRr;
  public static int hPm;
  public static int resultCode;
  
  static
  {
    AppMethodBeat.i(249953);
    afRq = new a();
    hPm = -1;
    AppMethodBeat.o(249953);
  }
  
  public static void a(int paramInt1, Intent paramIntent, int paramInt2)
  {
    resultCode = paramInt1;
    Ofj = paramIntent;
    hPm = paramInt2;
    afRr = true;
  }
  
  public static void reset()
  {
    resultCode = 0;
    Ofj = null;
    hPm = -1;
    afRr = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.e.a
 * JD-Core Version:    0.7.0.1
 */