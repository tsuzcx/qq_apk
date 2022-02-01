package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alj
  extends cvp
{
  public FinderContact Glf;
  public String Glg;
  public String Glh;
  public cgr entranceInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209264);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Glf != null)
      {
        paramVarArgs.lC(2, this.Glf.computeSize());
        this.Glf.writeFields(paramVarArgs);
      }
      if (this.Glg != null) {
        paramVarArgs.d(3, this.Glg);
      }
      if (this.Glh != null) {
        paramVarArgs.d(4, this.Glh);
      }
      if (this.entranceInfo != null)
      {
        paramVarArgs.lC(5, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209264);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Glf != null) {
        paramInt = i + f.a.a.a.lB(2, this.Glf.computeSize());
      }
      i = paramInt;
      if (this.Glg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Glg);
      }
      paramInt = i;
      if (this.Glh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Glh);
      }
      i = paramInt;
      if (this.entranceInfo != null) {
        i = paramInt + f.a.a.a.lB(5, this.entranceInfo.computeSize());
      }
      AppMethodBeat.o(209264);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209264);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alj localalj = (alj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209264);
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
            localalj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209264);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalj.Glf = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209264);
          return 0;
        case 3: 
          localalj.Glg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209264);
          return 0;
        case 4: 
          localalj.Glh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209264);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalj.entranceInfo = ((cgr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209264);
        return 0;
      }
      AppMethodBeat.o(209264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alj
 * JD-Core Version:    0.7.0.1
 */