package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fme
  extends com.tencent.mm.cd.a
{
  public String Cqt;
  public String Md5;
  public String UIr;
  public int UKR;
  public int UKS;
  public String UKX;
  public flw UKY;
  public fmd UKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110863);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UKX == null)
      {
        paramVarArgs = new b("Not all required fields were included: EntranceDomain");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.UIr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.UKX != null) {
        paramVarArgs.f(4, this.UKX);
      }
      if (this.UIr != null) {
        paramVarArgs.f(12, this.UIr);
      }
      if (this.UKY != null)
      {
        paramVarArgs.oE(9, this.UKY.computeSize());
        this.UKY.writeFields(paramVarArgs);
      }
      if (this.UKZ != null)
      {
        paramVarArgs.oE(10, this.UKZ.computeSize());
        this.UKZ.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(5, this.Md5);
      }
      if (this.Cqt != null) {
        paramVarArgs.f(6, this.Cqt);
      }
      paramVarArgs.aY(7, this.UKR);
      paramVarArgs.aY(8, this.UKS);
      AppMethodBeat.o(110863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UKX == null) {
        break label862;
      }
    }
    label862:
    for (int i = g.a.a.b.b.a.g(4, this.UKX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UIr != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.UIr);
      }
      i = paramInt;
      if (this.UKY != null) {
        i = paramInt + g.a.a.a.oD(9, this.UKY.computeSize());
      }
      paramInt = i;
      if (this.UKZ != null) {
        paramInt = i + g.a.a.a.oD(10, this.UKZ.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Md5);
      }
      paramInt = i;
      if (this.Cqt != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Cqt);
      }
      i = g.a.a.b.b.a.bM(7, this.UKR);
      int j = g.a.a.b.b.a.bM(8, this.UKS);
      AppMethodBeat.o(110863);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UKX == null)
        {
          paramVarArgs = new b("Not all required fields were included: EntranceDomain");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        if (this.UIr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Charset");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110863);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fme localfme = (fme)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(110863);
          return -1;
        case 4: 
          localfme.UKX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 12: 
          localfme.UIr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flw)localObject2).parseFrom((byte[])localObject1);
            }
            localfme.UKY = ((flw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmd)localObject2).parseFrom((byte[])localObject1);
            }
            localfme.UKZ = ((fmd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 5: 
          localfme.Md5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 6: 
          localfme.Cqt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 7: 
          localfme.UKR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(110863);
          return 0;
        }
        localfme.UKS = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(110863);
        return 0;
      }
      AppMethodBeat.o(110863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fme
 * JD-Core Version:    0.7.0.1
 */