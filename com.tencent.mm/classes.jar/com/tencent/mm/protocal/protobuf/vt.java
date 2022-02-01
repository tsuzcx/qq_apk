package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vt
  extends cld
{
  public String CJK;
  public int CXP;
  public LinkedList<dcg> CXQ;
  public int CXR;
  public String Md5;
  public int Version;
  
  public vt()
  {
    AppMethodBeat.i(6405);
    this.CXQ = new LinkedList();
    AppMethodBeat.o(6405);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6406);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(6406);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Version);
      if (this.CJK != null) {
        paramVarArgs.d(3, this.CJK);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      paramVarArgs.aR(5, this.CXP);
      paramVarArgs.e(6, 8, this.CXQ);
      paramVarArgs.aR(7, this.CXR);
      AppMethodBeat.o(6406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Version);
      paramInt = i;
      if (this.CJK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CJK);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Md5);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.CXP);
      int j = f.a.a.a.c(6, 8, this.CXQ);
      int k = f.a.a.b.b.a.bA(7, this.CXR);
      AppMethodBeat.o(6406);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CXQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(6406);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6406);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vt localvt = (vt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6406);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        case 2: 
          localvt.Version = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6406);
          return 0;
        case 3: 
          localvt.CJK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 4: 
          localvt.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 5: 
          localvt.CXP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6406);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvt.CXQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        }
        localvt.CXR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(6406);
        return 0;
      }
      AppMethodBeat.o(6406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vt
 * JD-Core Version:    0.7.0.1
 */