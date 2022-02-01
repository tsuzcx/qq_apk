package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bys
  extends com.tencent.mm.bw.a
{
  public int Hlu;
  public String Hlv;
  public String bssid;
  public String dnO;
  public int drL;
  public String ssid;
  public int tvY;
  
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
      paramVarArgs.aS(3, this.drL);
      paramVarArgs.aS(4, this.Hlu);
      if (this.Hlv != null) {
        paramVarArgs.d(5, this.Hlv);
      }
      if (this.dnO != null) {
        paramVarArgs.d(6, this.dnO);
      }
      paramVarArgs.aS(7, this.tvY);
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
      i = i + f.a.a.b.b.a.bz(3, this.drL) + f.a.a.b.b.a.bz(4, this.Hlu);
      paramInt = i;
      if (this.Hlv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hlv);
      }
      i = paramInt;
      if (this.dnO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dnO);
      }
      paramInt = f.a.a.b.b.a.bz(7, this.tvY);
      AppMethodBeat.o(32344);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32344);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bys localbys = (bys)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32344);
          return -1;
        case 1: 
          localbys.ssid = locala.OmT.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 2: 
          localbys.bssid = locala.OmT.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 3: 
          localbys.drL = locala.OmT.zc();
          AppMethodBeat.o(32344);
          return 0;
        case 4: 
          localbys.Hlu = locala.OmT.zc();
          AppMethodBeat.o(32344);
          return 0;
        case 5: 
          localbys.Hlv = locala.OmT.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 6: 
          localbys.dnO = locala.OmT.readString();
          AppMethodBeat.o(32344);
          return 0;
        }
        localbys.tvY = locala.OmT.zc();
        AppMethodBeat.o(32344);
        return 0;
      }
      AppMethodBeat.o(32344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bys
 * JD-Core Version:    0.7.0.1
 */