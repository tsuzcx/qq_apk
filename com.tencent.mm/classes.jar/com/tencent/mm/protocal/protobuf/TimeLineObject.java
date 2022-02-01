package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TimeLineObject
  extends com.tencent.mm.bx.a
{
  public String BXw;
  public int CreateTime;
  public int DMS;
  public String Etj;
  public bmn Etk;
  public eh Etl;
  public yk Etm;
  public String Etn;
  public int Eto;
  public int Etp;
  public String Etq;
  public czi Etr;
  public dqn Ets;
  public int Ett;
  public String Id;
  public int evt;
  public int gHj;
  public String jec;
  public String mAQ;
  public ay wLl;
  public dsx wLn;
  public String xns;
  public String xpl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      paramVarArgs.aR(3, this.DMS);
      paramVarArgs.aR(4, this.CreateTime);
      if (this.Etj != null) {
        paramVarArgs.d(5, this.Etj);
      }
      if (this.Etk != null)
      {
        paramVarArgs.kX(6, this.Etk.computeSize());
        this.Etk.writeFields(paramVarArgs);
      }
      if (this.Etl != null)
      {
        paramVarArgs.kX(7, this.Etl.computeSize());
        this.Etl.writeFields(paramVarArgs);
      }
      if (this.Etm != null)
      {
        paramVarArgs.kX(8, this.Etm.computeSize());
        this.Etm.writeFields(paramVarArgs);
      }
      if (this.jec != null) {
        paramVarArgs.d(9, this.jec);
      }
      if (this.BXw != null) {
        paramVarArgs.d(10, this.BXw);
      }
      if (this.Etn != null) {
        paramVarArgs.d(11, this.Etn);
      }
      paramVarArgs.aR(12, this.Eto);
      paramVarArgs.aR(13, this.Etp);
      if (this.Etq != null) {
        paramVarArgs.d(14, this.Etq);
      }
      if (this.wLl != null)
      {
        paramVarArgs.kX(15, this.wLl.computeSize());
        this.wLl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(16, this.gHj);
      if (this.Etr != null)
      {
        paramVarArgs.kX(17, this.Etr.computeSize());
        this.Etr.writeFields(paramVarArgs);
      }
      if (this.xns != null) {
        paramVarArgs.d(18, this.xns);
      }
      if (this.xpl != null) {
        paramVarArgs.d(19, this.xpl);
      }
      if (this.Ets != null)
      {
        paramVarArgs.kX(20, this.Ets.computeSize());
        this.Ets.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(21, this.Ett);
      if (this.wLn != null)
      {
        paramVarArgs.kX(22, this.wLn.computeSize());
        this.wLn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(23, this.evt);
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
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DMS) + f.a.a.b.b.a.bA(4, this.CreateTime);
      paramInt = i;
      if (this.Etj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Etj);
      }
      i = paramInt;
      if (this.Etk != null) {
        i = paramInt + f.a.a.a.kW(6, this.Etk.computeSize());
      }
      paramInt = i;
      if (this.Etl != null) {
        paramInt = i + f.a.a.a.kW(7, this.Etl.computeSize());
      }
      i = paramInt;
      if (this.Etm != null) {
        i = paramInt + f.a.a.a.kW(8, this.Etm.computeSize());
      }
      paramInt = i;
      if (this.jec != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jec);
      }
      i = paramInt;
      if (this.BXw != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.BXw);
      }
      paramInt = i;
      if (this.Etn != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Etn);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.Eto) + f.a.a.b.b.a.bA(13, this.Etp);
      paramInt = i;
      if (this.Etq != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Etq);
      }
      i = paramInt;
      if (this.wLl != null) {
        i = paramInt + f.a.a.a.kW(15, this.wLl.computeSize());
      }
      i += f.a.a.b.b.a.bA(16, this.gHj);
      paramInt = i;
      if (this.Etr != null) {
        paramInt = i + f.a.a.a.kW(17, this.Etr.computeSize());
      }
      i = paramInt;
      if (this.xns != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.xns);
      }
      paramInt = i;
      if (this.xpl != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.xpl);
      }
      i = paramInt;
      if (this.Ets != null) {
        i = paramInt + f.a.a.a.kW(20, this.Ets.computeSize());
      }
      i += f.a.a.b.b.a.bA(21, this.Ett);
      paramInt = i;
      if (this.wLn != null) {
        paramInt = i + f.a.a.a.kW(22, this.wLn.computeSize());
      }
      i = f.a.a.b.b.a.bA(23, this.evt);
      AppMethodBeat.o(125847);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localTimeLineObject.Id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 2: 
          localTimeLineObject.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 3: 
          localTimeLineObject.DMS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125847);
          return 0;
        case 4: 
          localTimeLineObject.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125847);
          return 0;
        case 5: 
          localTimeLineObject.Etj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.Etk = ((bmn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.Etl = ((eh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.Etm = ((yk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 9: 
          localTimeLineObject.jec = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 10: 
          localTimeLineObject.BXw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 11: 
          localTimeLineObject.Etn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 12: 
          localTimeLineObject.Eto = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125847);
          return 0;
        case 13: 
          localTimeLineObject.Etp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125847);
          return 0;
        case 14: 
          localTimeLineObject.Etq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ay();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.wLl = ((ay)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 16: 
          localTimeLineObject.gHj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125847);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.Etr = ((czi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 18: 
          localTimeLineObject.xns = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 19: 
          localTimeLineObject.xpl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.Ets = ((dqn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 21: 
          localTimeLineObject.Ett = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125847);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dsx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dsx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.wLn = ((dsx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        }
        localTimeLineObject.evt = ((f.a.a.a.a)localObject1).KhF.xS();
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