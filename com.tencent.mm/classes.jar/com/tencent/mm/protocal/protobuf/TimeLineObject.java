package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TimeLineObject
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String DpN;
  public String FQl;
  public brd FQm;
  public ej FQn;
  public zf FQo;
  public String FQp;
  public int FQq;
  public int FQr;
  public String FQs;
  public deu FQt;
  public dwe FQu;
  public int FQv;
  public int Fjj;
  public String Id;
  public int exP;
  public int hhK;
  public String jEq;
  public String ncR;
  public ba xXR;
  public dyo xXT;
  public String yAj;
  public String yCb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      paramVarArgs.aR(3, this.Fjj);
      paramVarArgs.aR(4, this.CreateTime);
      if (this.FQl != null) {
        paramVarArgs.d(5, this.FQl);
      }
      if (this.FQm != null)
      {
        paramVarArgs.ln(6, this.FQm.computeSize());
        this.FQm.writeFields(paramVarArgs);
      }
      if (this.FQn != null)
      {
        paramVarArgs.ln(7, this.FQn.computeSize());
        this.FQn.writeFields(paramVarArgs);
      }
      if (this.FQo != null)
      {
        paramVarArgs.ln(8, this.FQo.computeSize());
        this.FQo.writeFields(paramVarArgs);
      }
      if (this.jEq != null) {
        paramVarArgs.d(9, this.jEq);
      }
      if (this.DpN != null) {
        paramVarArgs.d(10, this.DpN);
      }
      if (this.FQp != null) {
        paramVarArgs.d(11, this.FQp);
      }
      paramVarArgs.aR(12, this.FQq);
      paramVarArgs.aR(13, this.FQr);
      if (this.FQs != null) {
        paramVarArgs.d(14, this.FQs);
      }
      if (this.xXR != null)
      {
        paramVarArgs.ln(15, this.xXR.computeSize());
        this.xXR.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(16, this.hhK);
      if (this.FQt != null)
      {
        paramVarArgs.ln(17, this.FQt.computeSize());
        this.FQt.writeFields(paramVarArgs);
      }
      if (this.yAj != null) {
        paramVarArgs.d(18, this.yAj);
      }
      if (this.yCb != null) {
        paramVarArgs.d(19, this.yCb);
      }
      if (this.FQu != null)
      {
        paramVarArgs.ln(20, this.FQu.computeSize());
        this.FQu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(21, this.FQv);
      if (this.xXT != null)
      {
        paramVarArgs.ln(22, this.xXT.computeSize());
        this.xXT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(23, this.exP);
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
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Fjj) + f.a.a.b.b.a.bx(4, this.CreateTime);
      paramInt = i;
      if (this.FQl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FQl);
      }
      i = paramInt;
      if (this.FQm != null) {
        i = paramInt + f.a.a.a.lm(6, this.FQm.computeSize());
      }
      paramInt = i;
      if (this.FQn != null) {
        paramInt = i + f.a.a.a.lm(7, this.FQn.computeSize());
      }
      i = paramInt;
      if (this.FQo != null) {
        i = paramInt + f.a.a.a.lm(8, this.FQo.computeSize());
      }
      paramInt = i;
      if (this.jEq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jEq);
      }
      i = paramInt;
      if (this.DpN != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DpN);
      }
      paramInt = i;
      if (this.FQp != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FQp);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.FQq) + f.a.a.b.b.a.bx(13, this.FQr);
      paramInt = i;
      if (this.FQs != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FQs);
      }
      i = paramInt;
      if (this.xXR != null) {
        i = paramInt + f.a.a.a.lm(15, this.xXR.computeSize());
      }
      i += f.a.a.b.b.a.bx(16, this.hhK);
      paramInt = i;
      if (this.FQt != null) {
        paramInt = i + f.a.a.a.lm(17, this.FQt.computeSize());
      }
      i = paramInt;
      if (this.yAj != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.yAj);
      }
      paramInt = i;
      if (this.yCb != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.yCb);
      }
      i = paramInt;
      if (this.FQu != null) {
        i = paramInt + f.a.a.a.lm(20, this.FQu.computeSize());
      }
      i += f.a.a.b.b.a.bx(21, this.FQv);
      paramInt = i;
      if (this.xXT != null) {
        paramInt = i + f.a.a.a.lm(22, this.xXT.computeSize());
      }
      i = f.a.a.b.b.a.bx(23, this.exP);
      AppMethodBeat.o(125847);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localTimeLineObject.Id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 2: 
          localTimeLineObject.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 3: 
          localTimeLineObject.Fjj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125847);
          return 0;
        case 4: 
          localTimeLineObject.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125847);
          return 0;
        case 5: 
          localTimeLineObject.FQl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.FQm = ((brd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ej();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.FQn = ((ej)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.FQo = ((zf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 9: 
          localTimeLineObject.jEq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 10: 
          localTimeLineObject.DpN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 11: 
          localTimeLineObject.FQp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 12: 
          localTimeLineObject.FQq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125847);
          return 0;
        case 13: 
          localTimeLineObject.FQr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125847);
          return 0;
        case 14: 
          localTimeLineObject.FQs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.xXR = ((ba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 16: 
          localTimeLineObject.hhK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125847);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.FQt = ((deu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 18: 
          localTimeLineObject.yAj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 19: 
          localTimeLineObject.yCb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.FQu = ((dwe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 21: 
          localTimeLineObject.FQv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125847);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.xXT = ((dyo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        }
        localTimeLineObject.exP = ((f.a.a.a.a)localObject1).LVo.xF();
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