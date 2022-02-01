package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class brd
  extends cvp
{
  public String FqI;
  public String FqV;
  public String GLA;
  public String GLB;
  public String GLC;
  public int GLD;
  public bql GLs;
  public String jdf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123613);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123613);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GLs != null)
      {
        paramVarArgs.lC(2, this.GLs.computeSize());
        this.GLs.writeFields(paramVarArgs);
      }
      if (this.GLB != null) {
        paramVarArgs.d(3, this.GLB);
      }
      if (this.FqV != null) {
        paramVarArgs.d(4, this.FqV);
      }
      if (this.FqI != null) {
        paramVarArgs.d(5, this.FqI);
      }
      if (this.GLC != null) {
        paramVarArgs.d(6, this.GLC);
      }
      paramVarArgs.aS(7, this.GLD);
      if (this.GLA != null) {
        paramVarArgs.d(8, this.GLA);
      }
      if (this.jdf != null) {
        paramVarArgs.d(9, this.jdf);
      }
      AppMethodBeat.o(123613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GLs != null) {
        paramInt = i + f.a.a.a.lB(2, this.GLs.computeSize());
      }
      i = paramInt;
      if (this.GLB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GLB);
      }
      paramInt = i;
      if (this.FqV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FqV);
      }
      i = paramInt;
      if (this.FqI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FqI);
      }
      paramInt = i;
      if (this.GLC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GLC);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GLD);
      paramInt = i;
      if (this.GLA != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GLA);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.jdf);
      }
      AppMethodBeat.o(123613);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123613);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brd localbrd = (brd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123613);
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
            localbrd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bql();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrd.GLs = ((bql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 3: 
          localbrd.GLB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 4: 
          localbrd.FqV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 5: 
          localbrd.FqI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 6: 
          localbrd.GLC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 7: 
          localbrd.GLD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123613);
          return 0;
        case 8: 
          localbrd.GLA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123613);
          return 0;
        }
        localbrd.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123613);
        return 0;
      }
      AppMethodBeat.o(123613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brd
 * JD-Core Version:    0.7.0.1
 */