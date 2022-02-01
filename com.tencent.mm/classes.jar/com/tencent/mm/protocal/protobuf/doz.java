package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doz
  extends com.tencent.mm.bw.a
{
  public LinkedList<aaj> DTg;
  public String HVO;
  public String HVP;
  public String HVQ;
  public String HVR;
  public long HVS;
  public dfc HVU;
  public boolean HWb;
  public LinkedList<dpa> HWf;
  public String dmf;
  public int offset;
  public String rfA;
  public int scene;
  
  public doz()
  {
    AppMethodBeat.i(153010);
    this.HWf = new LinkedList();
    this.DTg = new LinkedList();
    AppMethodBeat.o(153010);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153011);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HVO != null) {
        paramVarArgs.d(1, this.HVO);
      }
      if (this.HVP != null) {
        paramVarArgs.d(2, this.HVP);
      }
      if (this.HVQ != null) {
        paramVarArgs.d(3, this.HVQ);
      }
      if (this.HVR != null) {
        paramVarArgs.d(4, this.HVR);
      }
      if (this.HVU != null)
      {
        paramVarArgs.lJ(5, this.HVU.computeSize());
        this.HVU.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.HVS);
      if (this.rfA != null) {
        paramVarArgs.d(7, this.rfA);
      }
      paramVarArgs.aS(8, this.offset);
      paramVarArgs.bC(9, this.HWb);
      paramVarArgs.aS(10, this.scene);
      if (this.dmf != null) {
        paramVarArgs.d(11, this.dmf);
      }
      paramVarArgs.e(12, 8, this.HWf);
      paramVarArgs.e(13, 8, this.DTg);
      AppMethodBeat.o(153011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HVO == null) {
        break label1138;
      }
    }
    label1138:
    for (int i = f.a.a.b.b.a.e(1, this.HVO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HVP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HVP);
      }
      i = paramInt;
      if (this.HVQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HVQ);
      }
      paramInt = i;
      if (this.HVR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HVR);
      }
      i = paramInt;
      if (this.HVU != null) {
        i = paramInt + f.a.a.a.lI(5, this.HVU.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.HVS);
      paramInt = i;
      if (this.rfA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.rfA);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.offset) + f.a.a.b.b.a.amF(9) + f.a.a.b.b.a.bz(10, this.scene);
      paramInt = i;
      if (this.dmf != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dmf);
      }
      i = f.a.a.a.c(12, 8, this.HWf);
      int j = f.a.a.a.c(13, 8, this.DTg);
      AppMethodBeat.o(153011);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HWf.clear();
        this.DTg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        doz localdoz = (doz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153011);
          return -1;
        case 1: 
          localdoz.HVO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 2: 
          localdoz.HVP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 3: 
          localdoz.HVQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 4: 
          localdoz.HVR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoz.HVU = ((dfc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        case 6: 
          localdoz.HVS = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(153011);
          return 0;
        case 7: 
          localdoz.rfA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 8: 
          localdoz.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153011);
          return 0;
        case 9: 
          localdoz.HWb = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153011);
          return 0;
        case 10: 
          localdoz.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153011);
          return 0;
        case 11: 
          localdoz.dmf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoz.HWf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdoz.DTg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      AppMethodBeat.o(153011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doz
 * JD-Core Version:    0.7.0.1
 */