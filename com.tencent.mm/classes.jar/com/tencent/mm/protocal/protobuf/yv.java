package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class yv
  extends dyy
{
  public String EtJ;
  public long SkV;
  public long SkW;
  public String SkX;
  public String SkY;
  public int tqa;
  public String tqb;
  public String ufC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72458);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72458);
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
      paramVarArgs.bm(4, this.SkV);
      paramVarArgs.bm(5, this.SkW);
      if (this.SkX != null) {
        paramVarArgs.f(6, this.SkX);
      }
      if (this.SkY != null) {
        paramVarArgs.f(7, this.SkY);
      }
      if (this.EtJ != null) {
        paramVarArgs.f(8, this.EtJ);
      }
      if (this.ufC != null) {
        paramVarArgs.f(9, this.ufC);
      }
      AppMethodBeat.o(72458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label776;
      }
    }
    label776:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.SkV) + g.a.a.b.b.a.p(5, this.SkW);
      paramInt = i;
      if (this.SkX != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SkX);
      }
      i = paramInt;
      if (this.SkY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SkY);
      }
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.EtJ);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.ufC);
      }
      AppMethodBeat.o(72458);
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
          AppMethodBeat.o(72458);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        yv localyv = (yv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72458);
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
            localyv.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(72458);
          return 0;
        case 2: 
          localyv.tqa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72458);
          return 0;
        case 3: 
          localyv.tqb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 4: 
          localyv.SkV = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(72458);
          return 0;
        case 5: 
          localyv.SkW = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(72458);
          return 0;
        case 6: 
          localyv.SkX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 7: 
          localyv.SkY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 8: 
          localyv.EtJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72458);
          return 0;
        }
        localyv.ufC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72458);
        return 0;
      }
      AppMethodBeat.o(72458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yv
 * JD-Core Version:    0.7.0.1
 */