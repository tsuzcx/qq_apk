package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class but
  extends dyy
{
  public String SkY;
  public com.tencent.mm.cd.b TeS;
  public float TeT;
  public String TeU;
  public long TeV;
  public String action_data;
  public String color_data;
  public String person_id;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104370);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104370);
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
      if (this.person_id != null) {
        paramVarArgs.f(4, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.f(5, this.action_data);
      }
      paramVarArgs.i(6, this.TeT);
      if (this.SkY != null) {
        paramVarArgs.f(7, this.SkY);
      }
      if (this.TeU != null) {
        paramVarArgs.f(8, this.TeU);
      }
      if (this.color_data != null) {
        paramVarArgs.f(9, this.color_data);
      }
      if (this.TeS != null) {
        paramVarArgs.c(10, this.TeS);
      }
      paramVarArgs.bm(11, this.TeV);
      AppMethodBeat.o(104370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label903;
      }
    }
    label903:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.person_id);
      }
      paramInt = i;
      if (this.action_data != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.action_data);
      }
      i = paramInt + (g.a.a.b.b.a.gL(6) + 4);
      paramInt = i;
      if (this.SkY != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SkY);
      }
      i = paramInt;
      if (this.TeU != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TeU);
      }
      paramInt = i;
      if (this.color_data != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.color_data);
      }
      i = paramInt;
      if (this.TeS != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.TeS);
      }
      paramInt = g.a.a.b.b.a.p(11, this.TeV);
      AppMethodBeat.o(104370);
      return i + paramInt;
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104370);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        but localbut = (but)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104370);
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
            localbut.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(104370);
          return 0;
        case 2: 
          localbut.tqa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104370);
          return 0;
        case 3: 
          localbut.tqb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 4: 
          localbut.person_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 5: 
          localbut.action_data = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 6: 
          localbut.TeT = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(104370);
          return 0;
        case 7: 
          localbut.SkY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 8: 
          localbut.TeU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 9: 
          localbut.color_data = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 10: 
          localbut.TeS = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(104370);
          return 0;
        }
        localbut.TeV = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(104370);
        return 0;
      }
      AppMethodBeat.o(104370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.but
 * JD-Core Version:    0.7.0.1
 */