package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cny
  extends dop
{
  public String LOd;
  public cnh MtV;
  public b Muo;
  public cnk Mup;
  public float dTj;
  public String dkU;
  public String dkV;
  public b lastBuffer;
  public float latitude;
  public int scene;
  public long twJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209755);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MtV != null)
      {
        paramVarArgs.ni(2, this.MtV.computeSize());
        this.MtV.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.bb(4, this.twJ);
      paramVarArgs.E(6, this.dTj);
      paramVarArgs.E(7, this.latitude);
      if (this.LOd != null) {
        paramVarArgs.e(8, this.LOd);
      }
      paramVarArgs.aM(10, this.scene);
      if (this.dkU != null) {
        paramVarArgs.e(13, this.dkU);
      }
      if (this.dkV != null) {
        paramVarArgs.e(14, this.dkV);
      }
      if (this.Muo != null) {
        paramVarArgs.c(15, this.Muo);
      }
      if (this.Mup != null)
      {
        paramVarArgs.ni(16, this.Mup.computeSize());
        this.Mup.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209755);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1124;
      }
    }
    label1124:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MtV != null) {
        paramInt = i + g.a.a.a.nh(2, this.MtV.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = i + g.a.a.b.b.a.r(4, this.twJ) + (g.a.a.b.b.a.fS(6) + 4) + (g.a.a.b.b.a.fS(7) + 4);
      paramInt = i;
      if (this.LOd != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LOd);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.scene);
      paramInt = i;
      if (this.dkU != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.dkU);
      }
      i = paramInt;
      if (this.dkV != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.dkV);
      }
      paramInt = i;
      if (this.Muo != null) {
        paramInt = i + g.a.a.b.b.a.b(15, this.Muo);
      }
      i = paramInt;
      if (this.Mup != null) {
        i = paramInt + g.a.a.a.nh(16, this.Mup.computeSize());
      }
      AppMethodBeat.o(209755);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209755);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cny localcny = (cny)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 9: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(209755);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcny.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209755);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcny.MtV = ((cnh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209755);
          return 0;
        case 3: 
          localcny.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209755);
          return 0;
        case 4: 
          localcny.twJ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209755);
          return 0;
        case 6: 
          localcny.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209755);
          return 0;
        case 7: 
          localcny.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209755);
          return 0;
        case 8: 
          localcny.LOd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209755);
          return 0;
        case 10: 
          localcny.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209755);
          return 0;
        case 13: 
          localcny.dkU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209755);
          return 0;
        case 14: 
          localcny.dkV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209755);
          return 0;
        case 15: 
          localcny.Muo = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209755);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cnk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcny.Mup = ((cnk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209755);
        return 0;
      }
      AppMethodBeat.o(209755);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cny
 * JD-Core Version:    0.7.0.1
 */