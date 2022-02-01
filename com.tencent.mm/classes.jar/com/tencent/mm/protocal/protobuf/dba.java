package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dba
  extends cvw
{
  public String FSa;
  public LinkedList<Integer> HKc;
  public String HKd;
  public String HKe;
  public String dlT;
  public String dqk;
  public String dwb;
  
  public dba()
  {
    AppMethodBeat.i(123645);
    this.HKc = new LinkedList();
    AppMethodBeat.o(123645);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123646);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      paramVarArgs.e(3, 2, this.HKc);
      if (this.HKd != null) {
        paramVarArgs.d(4, this.HKd);
      }
      if (this.FSa != null) {
        paramVarArgs.d(5, this.FSa);
      }
      if (this.dqk != null) {
        paramVarArgs.d(6, this.dqk);
      }
      if (this.dlT != null) {
        paramVarArgs.d(7, this.dlT);
      }
      if (this.HKe != null) {
        paramVarArgs.d(8, this.HKe);
      }
      AppMethodBeat.o(123646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label737;
      }
    }
    label737:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dwb);
      }
      i += f.a.a.a.c(3, 2, this.HKc);
      paramInt = i;
      if (this.HKd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HKd);
      }
      i = paramInt;
      if (this.FSa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FSa);
      }
      paramInt = i;
      if (this.dqk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dqk);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dlT);
      }
      paramInt = i;
      if (this.HKe != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HKe);
      }
      AppMethodBeat.o(123646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123646);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dba localdba = (dba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123646);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdba.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123646);
          return 0;
        case 2: 
          localdba.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 3: 
          localdba.HKc.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(123646);
          return 0;
        case 4: 
          localdba.HKd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 5: 
          localdba.FSa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 6: 
          localdba.dqk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123646);
          return 0;
        case 7: 
          localdba.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123646);
          return 0;
        }
        localdba.HKe = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123646);
        return 0;
      }
      AppMethodBeat.o(123646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dba
 * JD-Core Version:    0.7.0.1
 */