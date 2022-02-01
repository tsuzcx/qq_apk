package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djw
  extends cqk
{
  public String FSH;
  public int FSO;
  public LinkedList<bnn> FSP;
  public bnn FSQ;
  public int nWx;
  public String nWy;
  public String subtitle;
  public String title;
  
  public djw()
  {
    AppMethodBeat.i(72603);
    this.FSP = new LinkedList();
    AppMethodBeat.o(72603);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72604);
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
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.d(5, this.subtitle);
      }
      paramVarArgs.aR(6, this.FSO);
      paramVarArgs.e(7, 8, this.FSP);
      if (this.FSQ != null)
      {
        paramVarArgs.ln(8, this.FSQ.computeSize());
        this.FSQ.writeFields(paramVarArgs);
      }
      if (this.FSH != null) {
        paramVarArgs.d(9, this.FSH);
      }
      AppMethodBeat.o(72604);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.title);
      }
      paramInt = i;
      if (this.subtitle != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.subtitle);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FSO) + f.a.a.a.c(7, 8, this.FSP);
      paramInt = i;
      if (this.FSQ != null) {
        paramInt = i + f.a.a.a.lm(8, this.FSQ.computeSize());
      }
      i = paramInt;
      if (this.FSH != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FSH);
      }
      AppMethodBeat.o(72604);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FSP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72604);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djw localdjw = (djw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72604);
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
            localdjw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 2: 
          localdjw.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72604);
          return 0;
        case 3: 
          localdjw.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 4: 
          localdjw.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 5: 
          localdjw.subtitle = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 6: 
          localdjw.FSO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72604);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.FSP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.FSQ = ((bnn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        }
        localdjw.FSH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72604);
        return 0;
      }
      AppMethodBeat.o(72604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djw
 * JD-Core Version:    0.7.0.1
 */