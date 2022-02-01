package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class uk
  extends cwj
{
  public String Gmc;
  public String Gmd;
  public String Gme;
  public String Gmf;
  public String dBI;
  public int dmy;
  public String phe;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197184);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(197184);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.dBI != null) {
        paramVarArgs.d(5, this.dBI);
      }
      if (this.Gmc != null) {
        paramVarArgs.d(6, this.Gmc);
      }
      if (this.Gmd != null) {
        paramVarArgs.d(7, this.Gmd);
      }
      if (this.Gme != null) {
        paramVarArgs.d(8, this.Gme);
      }
      if (this.Gmf != null) {
        paramVarArgs.d(9, this.Gmf);
      }
      AppMethodBeat.o(197184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.title);
      }
      paramInt = i;
      if (this.dBI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dBI);
      }
      i = paramInt;
      if (this.Gmc != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Gmc);
      }
      paramInt = i;
      if (this.Gmd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gmd);
      }
      i = paramInt;
      if (this.Gme != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Gme);
      }
      paramInt = i;
      if (this.Gmf != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gmf);
      }
      AppMethodBeat.o(197184);
      return paramInt;
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
          AppMethodBeat.o(197184);
          throw paramVarArgs;
        }
        AppMethodBeat.o(197184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uk localuk = (uk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197184);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197184);
          return 0;
        case 2: 
          localuk.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(197184);
          return 0;
        case 3: 
          localuk.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197184);
          return 0;
        case 4: 
          localuk.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197184);
          return 0;
        case 5: 
          localuk.dBI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197184);
          return 0;
        case 6: 
          localuk.Gmc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197184);
          return 0;
        case 7: 
          localuk.Gmd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197184);
          return 0;
        case 8: 
          localuk.Gme = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197184);
          return 0;
        }
        localuk.Gmf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(197184);
        return 0;
      }
      AppMethodBeat.o(197184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uk
 * JD-Core Version:    0.7.0.1
 */