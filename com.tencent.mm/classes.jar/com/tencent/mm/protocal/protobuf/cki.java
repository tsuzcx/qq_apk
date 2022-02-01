package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cki
  extends com.tencent.mm.bw.a
{
  public LinkedList<vk> LSL;
  public String MpG;
  public boolean MpH;
  public iu MpI;
  public String MpJ;
  public boolean MpK;
  public int MpL;
  public String MpM;
  public int MpN;
  public ehw MpO;
  public acl MpP;
  public String MpQ;
  public String MpR;
  
  public cki()
  {
    AppMethodBeat.i(91533);
    this.LSL = new LinkedList();
    AppMethodBeat.o(91533);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91534);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MpG != null) {
        paramVarArgs.e(1, this.MpG);
      }
      paramVarArgs.e(2, 8, this.LSL);
      paramVarArgs.cc(3, this.MpH);
      if (this.MpI != null)
      {
        paramVarArgs.ni(4, this.MpI.computeSize());
        this.MpI.writeFields(paramVarArgs);
      }
      if (this.MpJ != null) {
        paramVarArgs.e(5, this.MpJ);
      }
      paramVarArgs.cc(6, this.MpK);
      paramVarArgs.aM(7, this.MpL);
      if (this.MpM != null) {
        paramVarArgs.e(8, this.MpM);
      }
      paramVarArgs.aM(9, this.MpN);
      if (this.MpO != null)
      {
        paramVarArgs.ni(10, this.MpO.computeSize());
        this.MpO.writeFields(paramVarArgs);
      }
      if (this.MpP != null)
      {
        paramVarArgs.ni(11, this.MpP.computeSize());
        this.MpP.writeFields(paramVarArgs);
      }
      if (this.MpQ != null) {
        paramVarArgs.e(12, this.MpQ);
      }
      if (this.MpR != null) {
        paramVarArgs.e(13, this.MpR);
      }
      AppMethodBeat.o(91534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MpG == null) {
        break label1242;
      }
    }
    label1242:
    for (paramInt = g.a.a.b.b.a.f(1, this.MpG) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LSL) + (g.a.a.b.b.a.fS(3) + 1);
      paramInt = i;
      if (this.MpI != null) {
        paramInt = i + g.a.a.a.nh(4, this.MpI.computeSize());
      }
      i = paramInt;
      if (this.MpJ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MpJ);
      }
      i = i + (g.a.a.b.b.a.fS(6) + 1) + g.a.a.b.b.a.bu(7, this.MpL);
      paramInt = i;
      if (this.MpM != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MpM);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.MpN);
      paramInt = i;
      if (this.MpO != null) {
        paramInt = i + g.a.a.a.nh(10, this.MpO.computeSize());
      }
      i = paramInt;
      if (this.MpP != null) {
        i = paramInt + g.a.a.a.nh(11, this.MpP.computeSize());
      }
      paramInt = i;
      if (this.MpQ != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MpQ);
      }
      i = paramInt;
      if (this.MpR != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MpR);
      }
      AppMethodBeat.o(91534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LSL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cki localcki = (cki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91534);
          return -1;
        case 1: 
          localcki.MpG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcki.LSL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 3: 
          localcki.MpH = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91534);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcki.MpI = ((iu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 5: 
          localcki.MpJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 6: 
          localcki.MpK = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91534);
          return 0;
        case 7: 
          localcki.MpL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91534);
          return 0;
        case 8: 
          localcki.MpM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 9: 
          localcki.MpN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91534);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcki.MpO = ((ehw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcki.MpP = ((acl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 12: 
          localcki.MpQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91534);
          return 0;
        }
        localcki.MpR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91534);
        return 0;
      }
      AppMethodBeat.o(91534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cki
 * JD-Core Version:    0.7.0.1
 */