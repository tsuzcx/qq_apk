package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import g.a.a.b;
import java.util.LinkedList;

public final class sz
  extends dyy
{
  public c OSs;
  public long RZZ;
  public LinkedList<String> Saa;
  public int Sab;
  public int Sac;
  public String Sad;
  public String Sae;
  public String Saf;
  public String mKM;
  public int tqa;
  public String tqb;
  
  public sz()
  {
    AppMethodBeat.i(250012);
    this.Saa = new LinkedList();
    AppMethodBeat.o(250012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250013);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(250013);
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
      if (this.OSs != null)
      {
        paramVarArgs.oE(4, this.OSs.computeSize());
        this.OSs.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(5, this.RZZ);
      paramVarArgs.aY(6, this.Sac);
      paramVarArgs.e(7, 1, this.Saa);
      paramVarArgs.aY(8, this.Sab);
      if (this.Sad != null) {
        paramVarArgs.f(9, this.Sad);
      }
      if (this.Sae != null) {
        paramVarArgs.f(10, this.Sae);
      }
      if (this.Saf != null) {
        paramVarArgs.f(11, this.Saf);
      }
      if (this.mKM != null) {
        paramVarArgs.f(12, this.mKM);
      }
      AppMethodBeat.o(250013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.OSs != null) {
        i = paramInt + g.a.a.a.oD(4, this.OSs.computeSize());
      }
      i = i + g.a.a.b.b.a.p(5, this.RZZ) + g.a.a.b.b.a.bM(6, this.Sac) + g.a.a.a.c(7, 1, this.Saa) + g.a.a.b.b.a.bM(8, this.Sab);
      paramInt = i;
      if (this.Sad != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Sad);
      }
      i = paramInt;
      if (this.Sae != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Sae);
      }
      paramInt = i;
      if (this.Saf != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Saf);
      }
      i = paramInt;
      if (this.mKM != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.mKM);
      }
      AppMethodBeat.o(250013);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Saa.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(250013);
          throw paramVarArgs;
        }
        AppMethodBeat.o(250013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        sz localsz = (sz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250013);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localsz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250013);
          return 0;
        case 2: 
          localsz.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(250013);
          return 0;
        case 3: 
          localsz.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250013);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new c();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((c)localObject2).parseFrom((byte[])localObject1);
            }
            localsz.OSs = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250013);
          return 0;
        case 5: 
          localsz.RZZ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(250013);
          return 0;
        case 6: 
          localsz.Sac = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(250013);
          return 0;
        case 7: 
          localsz.Saa.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(250013);
          return 0;
        case 8: 
          localsz.Sab = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(250013);
          return 0;
        case 9: 
          localsz.Sad = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250013);
          return 0;
        case 10: 
          localsz.Sae = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250013);
          return 0;
        case 11: 
          localsz.Saf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250013);
          return 0;
        }
        localsz.mKM = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(250013);
        return 0;
      }
      AppMethodBeat.o(250013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sz
 * JD-Core Version:    0.7.0.1
 */