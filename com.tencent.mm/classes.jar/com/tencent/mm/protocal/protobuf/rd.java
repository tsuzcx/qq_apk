package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import g.a.a.b;
import java.util.LinkedList;

public final class rd
  extends dyy
{
  public c OSs;
  public long OSu;
  public long RZZ;
  public LinkedList<String> Saa;
  public int Sab;
  public int Sac;
  public String Sad;
  public String Sae;
  public String Saf;
  public boolean Sag;
  public int tqa;
  public String tqb;
  
  public rd()
  {
    AppMethodBeat.i(91377);
    this.Saa = new LinkedList();
    AppMethodBeat.o(91377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91378);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91378);
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
      paramVarArgs.bm(4, this.OSu);
      if (this.OSs != null)
      {
        paramVarArgs.oE(5, this.OSs.computeSize());
        this.OSs.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.RZZ);
      paramVarArgs.e(7, 1, this.Saa);
      paramVarArgs.aY(8, this.Sab);
      paramVarArgs.aY(9, this.Sac);
      if (this.Sad != null) {
        paramVarArgs.f(10, this.Sad);
      }
      if (this.Sae != null) {
        paramVarArgs.f(11, this.Sae);
      }
      if (this.Saf != null) {
        paramVarArgs.f(12, this.Saf);
      }
      paramVarArgs.co(13, this.Sag);
      AppMethodBeat.o(91378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1038;
      }
    }
    label1038:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.OSu);
      paramInt = i;
      if (this.OSs != null) {
        paramInt = i + g.a.a.a.oD(5, this.OSs.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.RZZ) + g.a.a.a.c(7, 1, this.Saa) + g.a.a.b.b.a.bM(8, this.Sab) + g.a.a.b.b.a.bM(9, this.Sac);
      paramInt = i;
      if (this.Sad != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Sad);
      }
      i = paramInt;
      if (this.Sae != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.Sae);
      }
      paramInt = i;
      if (this.Saf != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Saf);
      }
      i = g.a.a.b.b.a.gL(13);
      AppMethodBeat.o(91378);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(91378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rd localrd = (rd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91378);
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
            localrd.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 2: 
          localrd.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91378);
          return 0;
        case 3: 
          localrd.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 4: 
          localrd.OSu = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91378);
          return 0;
        case 5: 
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
            localrd.OSs = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 6: 
          localrd.RZZ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91378);
          return 0;
        case 7: 
          localrd.Saa.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(91378);
          return 0;
        case 8: 
          localrd.Sab = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91378);
          return 0;
        case 9: 
          localrd.Sac = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91378);
          return 0;
        case 10: 
          localrd.Sad = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 11: 
          localrd.Sae = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 12: 
          localrd.Saf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91378);
          return 0;
        }
        localrd.Sag = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(91378);
        return 0;
      }
      AppMethodBeat.o(91378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rd
 * JD-Core Version:    0.7.0.1
 */