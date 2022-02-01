package com.tencent.mm.plugin.wxpayreport.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragmentActivity;

public class b
{
  public MMFragmentActivity EzS;
  public boolean XJw = false;
  public boolean XJx = false;
  public boolean XJy = false;
  public int XJz = 0;
  public int bgColor = 0;
  public long hnM = 500L;
  public int id = 0;
  public View view = null;
  public String viewId;
  
  public b(boolean paramBoolean1, boolean paramBoolean2, long paramLong, View paramView, int paramInt1, String paramString, MMFragmentActivity paramMMFragmentActivity, boolean paramBoolean3, int paramInt2, int paramInt3)
  {
    this.XJw = paramBoolean1;
    this.XJx = paramBoolean2;
    this.hnM = paramLong;
    this.view = paramView;
    this.id = paramInt1;
    this.viewId = paramString;
    this.EzS = paramMMFragmentActivity;
    this.XJy = paramBoolean3;
    this.bgColor = paramInt2;
    this.XJz = paramInt3;
  }
  
  public static final class a
  {
    public MMFragmentActivity EzS;
    public boolean XJw = false;
    public boolean XJx = false;
    public boolean XJy = false;
    public int XJz = 0;
    public int bgColor = 0;
    public long hnM = 300L;
    public int id = 0;
    public View view = null;
    public String viewId;
    
    public final b a(int paramInt, String paramString, MMFragmentActivity paramMMFragmentActivity)
    {
      AppMethodBeat.i(261073);
      this.XJw = true;
      this.XJx = true;
      this.id = paramInt;
      this.viewId = paramString;
      this.EzS = paramMMFragmentActivity;
      this.XJy = false;
      this.bgColor = 0;
      this.XJz = 0;
      paramString = iFG();
      AppMethodBeat.o(261073);
      return paramString;
    }
    
    public final b iFG()
    {
      AppMethodBeat.i(261069);
      b localb = new b(this.XJw, this.XJx, this.hnM, this.view, this.id, this.viewId, this.EzS, this.XJy, this.bgColor, this.XJz);
      AppMethodBeat.o(261069);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.a.b
 * JD-Core Version:    0.7.0.1
 */