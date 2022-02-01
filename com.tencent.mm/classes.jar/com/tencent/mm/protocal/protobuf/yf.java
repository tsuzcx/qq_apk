package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yf
  extends cwj
{
  public String GaE;
  public int Gqi;
  public LinkedList<dof> Gqj;
  public int Gqk;
  public String Md5;
  public int Version;
  
  public yf()
  {
    AppMethodBeat.i(6405);
    this.Gqj = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Version);
      if (this.GaE != null) {
        paramVarArgs.d(3, this.GaE);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      paramVarArgs.aS(5, this.Gqi);
      paramVarArgs.e(6, 8, this.Gqj);
      paramVarArgs.aS(7, this.Gqk);
      AppMethodBeat.o(6406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Version);
      paramInt = i;
      if (this.GaE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GaE);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Md5);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.Gqi);
      int j = f.a.a.a.c(6, 8, this.Gqj);
      int k = f.a.a.b.b.a.bz(7, this.Gqk);
      AppMethodBeat.o(6406);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gqj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        yf localyf = (yf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6406);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        case 2: 
          localyf.Version = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6406);
          return 0;
        case 3: 
          localyf.GaE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 4: 
          localyf.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 5: 
          localyf.Gqi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6406);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dof();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dof)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyf.Gqj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        }
        localyf.Gqk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(6406);
        return 0;
      }
      AppMethodBeat.o(6406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yf
 * JD-Core Version:    0.7.0.1
 */