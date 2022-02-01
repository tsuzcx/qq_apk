package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfv
  extends com.tencent.mm.bw.a
{
  public exc LPr;
  public ewz LPs;
  public exb LPt;
  public boolean LPu;
  public boolean LPv;
  public String LPw;
  public String LPx;
  public int LPy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200199);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LPr != null)
      {
        paramVarArgs.ni(1, this.LPr.computeSize());
        this.LPr.writeFields(paramVarArgs);
      }
      if (this.LPs != null)
      {
        paramVarArgs.ni(2, this.LPs.computeSize());
        this.LPs.writeFields(paramVarArgs);
      }
      if (this.LPt != null)
      {
        paramVarArgs.ni(3, this.LPt.computeSize());
        this.LPt.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(4, this.LPu);
      paramVarArgs.cc(5, this.LPv);
      if (this.LPw != null) {
        paramVarArgs.e(6, this.LPw);
      }
      if (this.LPx != null) {
        paramVarArgs.e(7, this.LPx);
      }
      paramVarArgs.aM(99, this.LPy);
      AppMethodBeat.o(200199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LPr == null) {
        break label898;
      }
    }
    label898:
    for (int i = g.a.a.a.nh(1, this.LPr.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LPs != null) {
        paramInt = i + g.a.a.a.nh(2, this.LPs.computeSize());
      }
      i = paramInt;
      if (this.LPt != null) {
        i = paramInt + g.a.a.a.nh(3, this.LPt.computeSize());
      }
      i = i + (g.a.a.b.b.a.fS(4) + 1) + (g.a.a.b.b.a.fS(5) + 1);
      paramInt = i;
      if (this.LPw != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LPw);
      }
      i = paramInt;
      if (this.LPx != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LPx);
      }
      paramInt = g.a.a.b.b.a.bu(99, this.LPy);
      AppMethodBeat.o(200199);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bfv localbfv = (bfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200199);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new exc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((exc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfv.LPr = ((exc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200199);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ewz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ewz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfv.LPs = ((ewz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200199);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new exb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((exb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfv.LPt = ((exb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200199);
          return 0;
        case 4: 
          localbfv.LPu = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(200199);
          return 0;
        case 5: 
          localbfv.LPv = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(200199);
          return 0;
        case 6: 
          localbfv.LPw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200199);
          return 0;
        case 7: 
          localbfv.LPx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200199);
          return 0;
        }
        localbfv.LPy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(200199);
        return 0;
      }
      AppMethodBeat.o(200199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfv
 * JD-Core Version:    0.7.0.1
 */