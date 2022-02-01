package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ut
  extends com.tencent.mm.cd.a
{
  public String SfA;
  public String Sfu;
  public String Sfv;
  public String Sfw;
  public int Sfx;
  public String Sfy;
  public up Sfz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113968);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sfu != null) {
        paramVarArgs.f(1, this.Sfu);
      }
      if (this.Sfv != null) {
        paramVarArgs.f(2, this.Sfv);
      }
      if (this.Sfw != null) {
        paramVarArgs.f(3, this.Sfw);
      }
      paramVarArgs.aY(4, this.Sfx);
      if (this.Sfy != null) {
        paramVarArgs.f(5, this.Sfy);
      }
      if (this.Sfz != null)
      {
        paramVarArgs.oE(6, this.Sfz.computeSize());
        this.Sfz.writeFields(paramVarArgs);
      }
      if (this.SfA != null) {
        paramVarArgs.f(7, this.SfA);
      }
      AppMethodBeat.o(113968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sfu == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.b.b.a.g(1, this.Sfu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sfv != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sfv);
      }
      i = paramInt;
      if (this.Sfw != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sfw);
      }
      i += g.a.a.b.b.a.bM(4, this.Sfx);
      paramInt = i;
      if (this.Sfy != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sfy);
      }
      i = paramInt;
      if (this.Sfz != null) {
        i = paramInt + g.a.a.a.oD(6, this.Sfz.computeSize());
      }
      paramInt = i;
      if (this.SfA != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SfA);
      }
      AppMethodBeat.o(113968);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ut localut = (ut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113968);
          return -1;
        case 1: 
          localut.Sfu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 2: 
          localut.Sfv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 3: 
          localut.Sfw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 4: 
          localut.Sfx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(113968);
          return 0;
        case 5: 
          localut.Sfy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            up localup = new up();
            if ((localObject != null) && (localObject.length > 0)) {
              localup.parseFrom((byte[])localObject);
            }
            localut.Sfz = localup;
            paramInt += 1;
          }
          AppMethodBeat.o(113968);
          return 0;
        }
        localut.SfA = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(113968);
        return 0;
      }
      AppMethodBeat.o(113968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ut
 * JD-Core Version:    0.7.0.1
 */