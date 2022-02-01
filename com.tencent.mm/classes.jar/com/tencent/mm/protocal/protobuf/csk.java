package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csk
  extends com.tencent.mm.bw.a
{
  public String BcW;
  public String LGs;
  public String MwX;
  public csi Mxr;
  public String Mxs;
  public String Mxt;
  public int Mxu;
  public long Mxv;
  public String Mxw;
  public int createtime;
  public long dFm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256725);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mxr != null)
      {
        paramVarArgs.ni(2, this.Mxr.computeSize());
        this.Mxr.writeFields(paramVarArgs);
      }
      if (this.Mxs != null) {
        paramVarArgs.e(3, this.Mxs);
      }
      if (this.Mxt != null) {
        paramVarArgs.e(4, this.Mxt);
      }
      paramVarArgs.bb(5, this.dFm);
      if (this.BcW != null) {
        paramVarArgs.e(6, this.BcW);
      }
      if (this.MwX != null) {
        paramVarArgs.e(7, this.MwX);
      }
      paramVarArgs.aM(9, this.createtime);
      paramVarArgs.aM(13, this.Mxu);
      paramVarArgs.bb(14, this.Mxv);
      if (this.LGs != null) {
        paramVarArgs.e(15, this.LGs);
      }
      if (this.Mxw != null) {
        paramVarArgs.e(16, this.Mxw);
      }
      AppMethodBeat.o(256725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mxr == null) {
        break label874;
      }
    }
    label874:
    for (int i = g.a.a.a.nh(2, this.Mxr.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mxs != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Mxs);
      }
      i = paramInt;
      if (this.Mxt != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Mxt);
      }
      i += g.a.a.b.b.a.r(5, this.dFm);
      paramInt = i;
      if (this.BcW != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.BcW);
      }
      i = paramInt;
      if (this.MwX != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MwX);
      }
      i = i + g.a.a.b.b.a.bu(9, this.createtime) + g.a.a.b.b.a.bu(13, this.Mxu) + g.a.a.b.b.a.r(14, this.Mxv);
      paramInt = i;
      if (this.LGs != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.LGs);
      }
      i = paramInt;
      if (this.Mxw != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.Mxw);
      }
      AppMethodBeat.o(256725);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csk localcsk = (csk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(256725);
          return -1;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((csi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsk.Mxr = ((csi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256725);
          return 0;
        case 3: 
          localcsk.Mxs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256725);
          return 0;
        case 4: 
          localcsk.Mxt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256725);
          return 0;
        case 5: 
          localcsk.dFm = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(256725);
          return 0;
        case 6: 
          localcsk.BcW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256725);
          return 0;
        case 7: 
          localcsk.MwX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256725);
          return 0;
        case 9: 
          localcsk.createtime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256725);
          return 0;
        case 13: 
          localcsk.Mxu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256725);
          return 0;
        case 14: 
          localcsk.Mxv = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(256725);
          return 0;
        case 15: 
          localcsk.LGs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256725);
          return 0;
        }
        localcsk.Mxw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256725);
        return 0;
      }
      AppMethodBeat.o(256725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csk
 * JD-Core Version:    0.7.0.1
 */