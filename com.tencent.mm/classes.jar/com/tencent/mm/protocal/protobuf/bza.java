package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bza
  extends ckq
{
  public String CFH;
  public String CWf;
  public String CXk;
  public String CXl;
  public String CXm;
  public String CXn;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91580);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.CXk != null) {
        paramVarArgs.d(3, this.CXk);
      }
      if (this.CFH != null) {
        paramVarArgs.d(4, this.CFH);
      }
      if (this.CXl != null) {
        paramVarArgs.d(5, this.CXl);
      }
      if (this.CXm != null) {
        paramVarArgs.d(6, this.CXm);
      }
      if (this.CXn != null) {
        paramVarArgs.d(7, this.CXn);
      }
      if (this.CWf != null) {
        paramVarArgs.d(8, this.CWf);
      }
      AppMethodBeat.o(91580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.CXk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CXk);
      }
      paramInt = i;
      if (this.CFH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CFH);
      }
      i = paramInt;
      if (this.CXl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CXl);
      }
      paramInt = i;
      if (this.CXm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CXm);
      }
      i = paramInt;
      if (this.CXn != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CXn);
      }
      paramInt = i;
      if (this.CWf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CWf);
      }
      AppMethodBeat.o(91580);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bza localbza = (bza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91580);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbza.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91580);
          return 0;
        case 2: 
          localbza.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91580);
          return 0;
        case 3: 
          localbza.CXk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91580);
          return 0;
        case 4: 
          localbza.CFH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91580);
          return 0;
        case 5: 
          localbza.CXl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91580);
          return 0;
        case 6: 
          localbza.CXm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91580);
          return 0;
        case 7: 
          localbza.CXn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91580);
          return 0;
        }
        localbza.CWf = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91580);
        return 0;
      }
      AppMethodBeat.o(91580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bza
 * JD-Core Version:    0.7.0.1
 */