package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpl
  extends cvp
{
  public String HDq;
  public int HDx;
  public LinkedList<bry> HDy;
  public bry HDz;
  public int ozR;
  public String ozS;
  public String subtitle;
  public String title;
  
  public dpl()
  {
    AppMethodBeat.i(72603);
    this.HDy = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.d(5, this.subtitle);
      }
      paramVarArgs.aS(6, this.HDx);
      paramVarArgs.e(7, 8, this.HDy);
      if (this.HDz != null)
      {
        paramVarArgs.lC(8, this.HDz.computeSize());
        this.HDz.writeFields(paramVarArgs);
      }
      if (this.HDq != null) {
        paramVarArgs.d(9, this.HDq);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.title);
      }
      paramInt = i;
      if (this.subtitle != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.subtitle);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HDx) + f.a.a.a.c(7, 8, this.HDy);
      paramInt = i;
      if (this.HDz != null) {
        paramInt = i + f.a.a.a.lB(8, this.HDz.computeSize());
      }
      i = paramInt;
      if (this.HDq != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HDq);
      }
      AppMethodBeat.o(72604);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HDy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72604);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpl localdpl = (dpl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72604);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 2: 
          localdpl.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72604);
          return 0;
        case 3: 
          localdpl.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 4: 
          localdpl.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 5: 
          localdpl.subtitle = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 6: 
          localdpl.HDx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72604);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpl.HDy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpl.HDz = ((bry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        }
        localdpl.HDq = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72604);
        return 0;
      }
      AppMethodBeat.o(72604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpl
 * JD-Core Version:    0.7.0.1
 */