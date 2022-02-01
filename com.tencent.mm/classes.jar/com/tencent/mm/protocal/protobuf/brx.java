package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class brx
  extends cwj
{
  public String FJg;
  public String FJt;
  public brf HeT;
  public String Hfb;
  public String Hfc;
  public String Hfd;
  public int Hfe;
  public String jfY;
  
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HeT != null)
      {
        paramVarArgs.lJ(2, this.HeT.computeSize());
        this.HeT.writeFields(paramVarArgs);
      }
      if (this.Hfc != null) {
        paramVarArgs.d(3, this.Hfc);
      }
      if (this.FJt != null) {
        paramVarArgs.d(4, this.FJt);
      }
      if (this.FJg != null) {
        paramVarArgs.d(5, this.FJg);
      }
      if (this.Hfd != null) {
        paramVarArgs.d(6, this.Hfd);
      }
      paramVarArgs.aS(7, this.Hfe);
      if (this.Hfb != null) {
        paramVarArgs.d(8, this.Hfb);
      }
      if (this.jfY != null) {
        paramVarArgs.d(9, this.jfY);
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
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HeT != null) {
        paramInt = i + f.a.a.a.lI(2, this.HeT.computeSize());
      }
      i = paramInt;
      if (this.Hfc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hfc);
      }
      paramInt = i;
      if (this.FJt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FJt);
      }
      i = paramInt;
      if (this.FJg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FJg);
      }
      paramInt = i;
      if (this.Hfd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hfd);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Hfe);
      paramInt = i;
      if (this.Hfb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hfb);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.jfY);
      }
      AppMethodBeat.o(123613);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        brx localbrx = (brx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123613);
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
            localbrx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrx.HeT = ((brf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 3: 
          localbrx.Hfc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 4: 
          localbrx.FJt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 5: 
          localbrx.FJg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 6: 
          localbrx.Hfd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 7: 
          localbrx.Hfe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123613);
          return 0;
        case 8: 
          localbrx.Hfb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123613);
          return 0;
        }
        localbrx.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123613);
        return 0;
      }
      AppMethodBeat.o(123613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brx
 * JD-Core Version:    0.7.0.1
 */