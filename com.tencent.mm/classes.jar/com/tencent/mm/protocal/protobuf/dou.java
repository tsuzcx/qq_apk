package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dou
  extends com.tencent.mm.bw.a
{
  public int DTy;
  public int DUs;
  public int DUt;
  public int DUu;
  public long HVF;
  public int HVG;
  public long HVH;
  public String dEM;
  public int eQZ;
  public String extInfo;
  public int iqb;
  public long irN;
  public String msgId;
  public String text;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153002);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.msgId != null) {
        paramVarArgs.d(1, this.msgId);
      }
      paramVarArgs.aS(2, this.DUs);
      paramVarArgs.aS(3, this.DUt);
      paramVarArgs.aZ(4, this.irN);
      paramVarArgs.aS(5, this.DTy);
      paramVarArgs.aS(6, this.type);
      if (this.text != null) {
        paramVarArgs.d(7, this.text);
      }
      if (this.dEM != null) {
        paramVarArgs.d(8, this.dEM);
      }
      paramVarArgs.aZ(9, this.HVF);
      paramVarArgs.aS(10, this.DUu);
      paramVarArgs.aS(11, this.HVG);
      paramVarArgs.aZ(12, this.HVH);
      paramVarArgs.aS(13, this.eQZ);
      paramVarArgs.aS(14, this.iqb);
      if (this.extInfo != null) {
        paramVarArgs.d(15, this.extInfo);
      }
      AppMethodBeat.o(153002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.msgId == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.b.b.a.e(1, this.msgId) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.DUs) + f.a.a.b.b.a.bz(3, this.DUt) + f.a.a.b.b.a.p(4, this.irN) + f.a.a.b.b.a.bz(5, this.DTy) + f.a.a.b.b.a.bz(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.text);
      }
      i = paramInt;
      if (this.dEM != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dEM);
      }
      i = i + f.a.a.b.b.a.p(9, this.HVF) + f.a.a.b.b.a.bz(10, this.DUu) + f.a.a.b.b.a.bz(11, this.HVG) + f.a.a.b.b.a.p(12, this.HVH) + f.a.a.b.b.a.bz(13, this.eQZ) + f.a.a.b.b.a.bz(14, this.iqb);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.extInfo);
      }
      AppMethodBeat.o(153002);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153002);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dou localdou = (dou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153002);
          return -1;
        case 1: 
          localdou.msgId = locala.OmT.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 2: 
          localdou.DUs = locala.OmT.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 3: 
          localdou.DUt = locala.OmT.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 4: 
          localdou.irN = locala.OmT.zd();
          AppMethodBeat.o(153002);
          return 0;
        case 5: 
          localdou.DTy = locala.OmT.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 6: 
          localdou.type = locala.OmT.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 7: 
          localdou.text = locala.OmT.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 8: 
          localdou.dEM = locala.OmT.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 9: 
          localdou.HVF = locala.OmT.zd();
          AppMethodBeat.o(153002);
          return 0;
        case 10: 
          localdou.DUu = locala.OmT.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 11: 
          localdou.HVG = locala.OmT.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 12: 
          localdou.HVH = locala.OmT.zd();
          AppMethodBeat.o(153002);
          return 0;
        case 13: 
          localdou.eQZ = locala.OmT.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 14: 
          localdou.iqb = locala.OmT.zc();
          AppMethodBeat.o(153002);
          return 0;
        }
        localdou.extInfo = locala.OmT.readString();
        AppMethodBeat.o(153002);
        return 0;
      }
      AppMethodBeat.o(153002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dou
 * JD-Core Version:    0.7.0.1
 */