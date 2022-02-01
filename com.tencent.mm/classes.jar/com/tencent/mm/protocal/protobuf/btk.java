package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btk
  extends com.tencent.mm.bw.a
{
  public int Fis;
  public String Fit;
  public String bssid;
  public String dbq;
  public int dfk;
  public int soD;
  public String ssid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32344);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ssid != null) {
        paramVarArgs.d(1, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(2, this.bssid);
      }
      paramVarArgs.aR(3, this.dfk);
      paramVarArgs.aR(4, this.Fis);
      if (this.Fit != null) {
        paramVarArgs.d(5, this.Fit);
      }
      if (this.dbq != null) {
        paramVarArgs.d(6, this.dbq);
      }
      paramVarArgs.aR(7, this.soD);
      AppMethodBeat.o(32344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label543;
      }
    }
    label543:
    for (paramInt = f.a.a.b.b.a.e(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.bssid);
      }
      i = i + f.a.a.b.b.a.bx(3, this.dfk) + f.a.a.b.b.a.bx(4, this.Fis);
      paramInt = i;
      if (this.Fit != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fit);
      }
      i = paramInt;
      if (this.dbq != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dbq);
      }
      paramInt = f.a.a.b.b.a.bx(7, this.soD);
      AppMethodBeat.o(32344);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32344);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        btk localbtk = (btk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32344);
          return -1;
        case 1: 
          localbtk.ssid = locala.LVo.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 2: 
          localbtk.bssid = locala.LVo.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 3: 
          localbtk.dfk = locala.LVo.xF();
          AppMethodBeat.o(32344);
          return 0;
        case 4: 
          localbtk.Fis = locala.LVo.xF();
          AppMethodBeat.o(32344);
          return 0;
        case 5: 
          localbtk.Fit = locala.LVo.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 6: 
          localbtk.dbq = locala.LVo.readString();
          AppMethodBeat.o(32344);
          return 0;
        }
        localbtk.soD = locala.LVo.xF();
        AppMethodBeat.o(32344);
        return 0;
      }
      AppMethodBeat.o(32344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btk
 * JD-Core Version:    0.7.0.1
 */