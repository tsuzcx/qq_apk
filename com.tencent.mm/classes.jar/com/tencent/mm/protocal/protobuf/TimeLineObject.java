package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TimeLineObject
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String EUR;
  public int GSK;
  public String HAQ;
  public bvq HAR;
  public en HAS;
  public abf HAT;
  public String HAU;
  public int HAV;
  public int HAW;
  public String HAX;
  public dkh HAY;
  public ece HAZ;
  public int HBa;
  public String Id;
  public int ePo;
  public int hzT;
  public String jYs;
  public String nDo;
  public String zRz;
  public String zTv;
  public ba znQ;
  public eeq znS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      paramVarArgs.aS(3, this.GSK);
      paramVarArgs.aS(4, this.CreateTime);
      if (this.HAQ != null) {
        paramVarArgs.d(5, this.HAQ);
      }
      if (this.HAR != null)
      {
        paramVarArgs.lC(6, this.HAR.computeSize());
        this.HAR.writeFields(paramVarArgs);
      }
      if (this.HAS != null)
      {
        paramVarArgs.lC(7, this.HAS.computeSize());
        this.HAS.writeFields(paramVarArgs);
      }
      if (this.HAT != null)
      {
        paramVarArgs.lC(8, this.HAT.computeSize());
        this.HAT.writeFields(paramVarArgs);
      }
      if (this.jYs != null) {
        paramVarArgs.d(9, this.jYs);
      }
      if (this.EUR != null) {
        paramVarArgs.d(10, this.EUR);
      }
      if (this.HAU != null) {
        paramVarArgs.d(11, this.HAU);
      }
      paramVarArgs.aS(12, this.HAV);
      paramVarArgs.aS(13, this.HAW);
      if (this.HAX != null) {
        paramVarArgs.d(14, this.HAX);
      }
      if (this.znQ != null)
      {
        paramVarArgs.lC(15, this.znQ.computeSize());
        this.znQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.hzT);
      if (this.HAY != null)
      {
        paramVarArgs.lC(17, this.HAY.computeSize());
        this.HAY.writeFields(paramVarArgs);
      }
      if (this.zRz != null) {
        paramVarArgs.d(18, this.zRz);
      }
      if (this.zTv != null) {
        paramVarArgs.d(19, this.zTv);
      }
      if (this.HAZ != null)
      {
        paramVarArgs.lC(20, this.HAZ.computeSize());
        this.HAZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(21, this.HBa);
      if (this.znS != null)
      {
        paramVarArgs.lC(22, this.znS.computeSize());
        this.znS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(23, this.ePo);
      AppMethodBeat.o(125847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2114;
      }
    }
    label2114:
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GSK) + f.a.a.b.b.a.bz(4, this.CreateTime);
      paramInt = i;
      if (this.HAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HAQ);
      }
      i = paramInt;
      if (this.HAR != null) {
        i = paramInt + f.a.a.a.lB(6, this.HAR.computeSize());
      }
      paramInt = i;
      if (this.HAS != null) {
        paramInt = i + f.a.a.a.lB(7, this.HAS.computeSize());
      }
      i = paramInt;
      if (this.HAT != null) {
        i = paramInt + f.a.a.a.lB(8, this.HAT.computeSize());
      }
      paramInt = i;
      if (this.jYs != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jYs);
      }
      i = paramInt;
      if (this.EUR != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.EUR);
      }
      paramInt = i;
      if (this.HAU != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HAU);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.HAV) + f.a.a.b.b.a.bz(13, this.HAW);
      paramInt = i;
      if (this.HAX != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HAX);
      }
      i = paramInt;
      if (this.znQ != null) {
        i = paramInt + f.a.a.a.lB(15, this.znQ.computeSize());
      }
      i += f.a.a.b.b.a.bz(16, this.hzT);
      paramInt = i;
      if (this.HAY != null) {
        paramInt = i + f.a.a.a.lB(17, this.HAY.computeSize());
      }
      i = paramInt;
      if (this.zRz != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.zRz);
      }
      paramInt = i;
      if (this.zTv != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.zTv);
      }
      i = paramInt;
      if (this.HAZ != null) {
        i = paramInt + f.a.a.a.lB(20, this.HAZ.computeSize());
      }
      i += f.a.a.b.b.a.bz(21, this.HBa);
      paramInt = i;
      if (this.znS != null) {
        paramInt = i + f.a.a.a.lB(22, this.znS.computeSize());
      }
      i = f.a.a.b.b.a.bz(23, this.ePo);
      AppMethodBeat.o(125847);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        TimeLineObject localTimeLineObject = (TimeLineObject)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125847);
          return -1;
        case 1: 
          localTimeLineObject.Id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 2: 
          localTimeLineObject.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 3: 
          localTimeLineObject.GSK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 4: 
          localTimeLineObject.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 5: 
          localTimeLineObject.HAQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HAR = ((bvq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new en();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((en)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HAS = ((en)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HAT = ((abf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 9: 
          localTimeLineObject.jYs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 10: 
          localTimeLineObject.EUR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 11: 
          localTimeLineObject.HAU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 12: 
          localTimeLineObject.HAV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 13: 
          localTimeLineObject.HAW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 14: 
          localTimeLineObject.HAX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.znQ = ((ba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 16: 
          localTimeLineObject.hzT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HAY = ((dkh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 18: 
          localTimeLineObject.zRz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 19: 
          localTimeLineObject.zTv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ece();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ece)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HAZ = ((ece)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 21: 
          localTimeLineObject.HBa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eeq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eeq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.znS = ((eeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        }
        localTimeLineObject.ePo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125847);
        return 0;
      }
      AppMethodBeat.o(125847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.TimeLineObject
 * JD-Core Version:    0.7.0.1
 */