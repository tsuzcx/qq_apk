package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class buz
  extends dyy
{
  public String ORR;
  public int Tfc;
  public String Tfd;
  public String Tfe;
  public String Tff;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197057);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(197057);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.Tfc);
      if (this.Tfd != null) {
        paramVarArgs.f(5, this.Tfd);
      }
      if (this.ORR != null) {
        paramVarArgs.f(6, this.ORR);
      }
      if (this.Tfe != null) {
        paramVarArgs.f(7, this.Tfe);
      }
      if (this.Tff != null) {
        paramVarArgs.f(8, this.Tff);
      }
      AppMethodBeat.o(197057);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.Tfc);
      paramInt = i;
      if (this.Tfd != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tfd);
      }
      i = paramInt;
      if (this.ORR != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ORR);
      }
      paramInt = i;
      if (this.Tfe != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Tfe);
      }
      i = paramInt;
      if (this.Tff != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Tff);
      }
      AppMethodBeat.o(197057);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(197057);
          throw paramVarArgs;
        }
        AppMethodBeat.o(197057);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        buz localbuz = (buz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197057);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localbuz.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(197057);
          return 0;
        case 2: 
          localbuz.tqa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(197057);
          return 0;
        case 3: 
          localbuz.tqb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(197057);
          return 0;
        case 4: 
          localbuz.Tfc = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(197057);
          return 0;
        case 5: 
          localbuz.Tfd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(197057);
          return 0;
        case 6: 
          localbuz.ORR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(197057);
          return 0;
        case 7: 
          localbuz.Tfe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(197057);
          return 0;
        }
        localbuz.Tff = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(197057);
        return 0;
      }
      AppMethodBeat.o(197057);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buz
 * JD-Core Version:    0.7.0.1
 */