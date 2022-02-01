package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtz
  extends dyy
{
  public int EtH;
  public int EtI;
  public String EtJ;
  public com.tencent.mm.cd.b TNj;
  public int TNk;
  public int TNl;
  public String TNp;
  public String TNq;
  public String TNr;
  public int TNs;
  public String TNu;
  public String tsf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91662);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91662);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TNk);
      if (this.EtJ != null) {
        paramVarArgs.f(3, this.EtJ);
      }
      if (this.TNq != null) {
        paramVarArgs.f(4, this.TNq);
      }
      if (this.TNr != null) {
        paramVarArgs.f(5, this.TNr);
      }
      if (this.TNj != null) {
        paramVarArgs.c(6, this.TNj);
      }
      paramVarArgs.aY(7, this.TNl);
      paramVarArgs.aY(8, this.EtH);
      paramVarArgs.aY(9, this.TNs);
      paramVarArgs.aY(10, this.EtI);
      if (this.tsf != null) {
        paramVarArgs.f(11, this.tsf);
      }
      if (this.TNu != null) {
        paramVarArgs.f(12, this.TNu);
      }
      if (this.TNp != null) {
        paramVarArgs.f(13, this.TNp);
      }
      AppMethodBeat.o(91662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label988;
      }
    }
    label988:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TNk);
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.EtJ);
      }
      i = paramInt;
      if (this.TNq != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TNq);
      }
      paramInt = i;
      if (this.TNr != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TNr);
      }
      i = paramInt;
      if (this.TNj != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.TNj);
      }
      i = i + g.a.a.b.b.a.bM(7, this.TNl) + g.a.a.b.b.a.bM(8, this.EtH) + g.a.a.b.b.a.bM(9, this.TNs) + g.a.a.b.b.a.bM(10, this.EtI);
      paramInt = i;
      if (this.tsf != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.tsf);
      }
      i = paramInt;
      if (this.TNu != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TNu);
      }
      paramInt = i;
      if (this.TNp != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.TNp);
      }
      AppMethodBeat.o(91662);
      return paramInt;
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
          AppMethodBeat.o(91662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dtz localdtz = (dtz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91662);
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
            localdtz.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91662);
          return 0;
        case 2: 
          localdtz.TNk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91662);
          return 0;
        case 3: 
          localdtz.EtJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 4: 
          localdtz.TNq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 5: 
          localdtz.TNr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 6: 
          localdtz.TNj = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(91662);
          return 0;
        case 7: 
          localdtz.TNl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91662);
          return 0;
        case 8: 
          localdtz.EtH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91662);
          return 0;
        case 9: 
          localdtz.TNs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91662);
          return 0;
        case 10: 
          localdtz.EtI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91662);
          return 0;
        case 11: 
          localdtz.tsf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 12: 
          localdtz.TNu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91662);
          return 0;
        }
        localdtz.TNp = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91662);
        return 0;
      }
      AppMethodBeat.o(91662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtz
 * JD-Core Version:    0.7.0.1
 */