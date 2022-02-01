package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djs
  extends cqk
{
  public String DZN;
  public String FSA;
  public String FSB;
  public coc FSJ;
  public LinkedList<abu> FSK;
  public String FSL;
  public String FSM;
  public String FSN;
  public coc FSy;
  public String FSz;
  public String nUG;
  public int nWx;
  public String nWy;
  public String wHu;
  public String wHv;
  public int wHw;
  public int wLy;
  
  public djs()
  {
    AppMethodBeat.i(72598);
    this.FSK = new LinkedList();
    AppMethodBeat.o(72598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72599);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.aR(4, this.wHw);
      if (this.FSJ != null)
      {
        paramVarArgs.ln(5, this.FSJ.computeSize());
        this.FSJ.writeFields(paramVarArgs);
      }
      if (this.FSz != null) {
        paramVarArgs.d(6, this.FSz);
      }
      if (this.FSA != null) {
        paramVarArgs.d(7, this.FSA);
      }
      if (this.wHu != null) {
        paramVarArgs.d(8, this.wHu);
      }
      if (this.wHv != null) {
        paramVarArgs.d(9, this.wHv);
      }
      if (this.nUG != null) {
        paramVarArgs.d(10, this.nUG);
      }
      if (this.DZN != null) {
        paramVarArgs.d(11, this.DZN);
      }
      paramVarArgs.aR(12, this.wLy);
      paramVarArgs.e(13, 8, this.FSK);
      if (this.FSL != null) {
        paramVarArgs.d(14, this.FSL);
      }
      if (this.FSM != null) {
        paramVarArgs.d(15, this.FSM);
      }
      if (this.FSB != null) {
        paramVarArgs.d(16, this.FSB);
      }
      if (this.FSN != null) {
        paramVarArgs.d(17, this.FSN);
      }
      if (this.FSy != null)
      {
        paramVarArgs.ln(18, this.FSy.computeSize());
        this.FSy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1574;
      }
    }
    label1574:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.wHw);
      paramInt = i;
      if (this.FSJ != null) {
        paramInt = i + f.a.a.a.lm(5, this.FSJ.computeSize());
      }
      i = paramInt;
      if (this.FSz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FSz);
      }
      paramInt = i;
      if (this.FSA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FSA);
      }
      i = paramInt;
      if (this.wHu != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.wHu);
      }
      paramInt = i;
      if (this.wHv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.wHv);
      }
      i = paramInt;
      if (this.nUG != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.nUG);
      }
      paramInt = i;
      if (this.DZN != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DZN);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.wLy) + f.a.a.a.c(13, 8, this.FSK);
      paramInt = i;
      if (this.FSL != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FSL);
      }
      i = paramInt;
      if (this.FSM != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.FSM);
      }
      paramInt = i;
      if (this.FSB != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FSB);
      }
      i = paramInt;
      if (this.FSN != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FSN);
      }
      paramInt = i;
      if (this.FSy != null) {
        paramInt = i + f.a.a.a.lm(18, this.FSy.computeSize());
      }
      AppMethodBeat.o(72599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FSK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djs localdjs = (djs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72599);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 2: 
          localdjs.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72599);
          return 0;
        case 3: 
          localdjs.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 4: 
          localdjs.wHw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72599);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjs.FSJ = ((coc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 6: 
          localdjs.FSz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 7: 
          localdjs.FSA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 8: 
          localdjs.wHu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 9: 
          localdjs.wHv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 10: 
          localdjs.nUG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 11: 
          localdjs.DZN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 12: 
          localdjs.wLy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72599);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjs.FSK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 14: 
          localdjs.FSL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 15: 
          localdjs.FSM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 16: 
          localdjs.FSB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 17: 
          localdjs.FSN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new coc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjs.FSy = ((coc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      AppMethodBeat.o(72599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djs
 * JD-Core Version:    0.7.0.1
 */