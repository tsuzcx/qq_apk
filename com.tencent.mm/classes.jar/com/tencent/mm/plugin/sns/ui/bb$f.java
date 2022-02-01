package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

abstract class bb$f
{
  View.OnClickListener xDW = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99033);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99033);
        return;
      }
      ad.d("MicroMsg.SnsphotoAdapter", "sign click");
      bb.f.this.xEa = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.xEa.dzf;
      int j = bb.f.this.xEa.position;
      bb.f.this.hq(i, j + 2);
      AppMethodBeat.o(99033);
    }
  };
  View.OnClickListener xDX = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99034);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99034);
        return;
      }
      ad.d("MicroMsg.SnsphotoAdapter", "sign click");
      bb.f.this.xEa = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.xEa.dzf;
      bb.f.this.Nz(i);
      AppMethodBeat.o(99034);
    }
  };
  View.OnClickListener xDY = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99035);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99035);
        return;
      }
      ad.d("MicroMsg.SnsphotoAdapter", "snssight click");
      bb.f.this.xEa = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.xEa.dzf;
      int j = bb.f.this.xEa.position;
      bb.f.this.hq(i, j + 2);
      AppMethodBeat.o(99035);
    }
  };
  View.OnLongClickListener xDZ = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99036);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99036);
        return true;
      }
      ad.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
      bb.f.this.xEa = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.xEa.dzf;
      int j = bb.f.this.xEa.position;
      bb.f.this.hr(i, j);
      AppMethodBeat.o(99036);
      return true;
    }
  };
  public bb.f.a xEa = new bb.f.a();
  View.OnClickListener xjW = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99030);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99030);
        return;
      }
      bb.f.this.xEa = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.xEa.dzf;
      int j = bb.f.this.xEa.position;
      bb.f.this.hp(i, j);
      AppMethodBeat.o(99030);
    }
  };
  View.OnClickListener xjX = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99031);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99031);
        return;
      }
      bb.f.this.xEa = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.xEa.dzf;
      int j = bb.f.this.xEa.position;
      bb.f.this.hp(i, j + 1);
      AppMethodBeat.o(99031);
    }
  };
  View.OnClickListener xjY = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99032);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99032);
        return;
      }
      bb.f.this.xEa = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.xEa.dzf;
      int j = bb.f.this.xEa.position;
      bb.f.this.hp(i, j + 2);
      AppMethodBeat.o(99032);
    }
  };
  
  public abstract void Nz(int paramInt);
  
  public abstract void hp(int paramInt1, int paramInt2);
  
  public abstract void hq(int paramInt1, int paramInt2);
  
  public abstract void hr(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb.f
 * JD-Core Version:    0.7.0.1
 */