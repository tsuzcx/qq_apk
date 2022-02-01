package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqr
  extends com.tencent.mm.cd.a
{
  public String Tyc;
  public String Tyd;
  public eys Tye;
  public String Tyf;
  public String Tyg;
  public String Tyh;
  public String Tyi;
  public String desc;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250418);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.Tyc != null) {
        paramVarArgs.f(3, this.Tyc);
      }
      if (this.Tyd != null) {
        paramVarArgs.f(4, this.Tyd);
      }
      if (this.Tye != null)
      {
        paramVarArgs.oE(5, this.Tye.computeSize());
        this.Tye.writeFields(paramVarArgs);
      }
      if (this.Tyf != null) {
        paramVarArgs.f(6, this.Tyf);
      }
      if (this.Tyg != null) {
        paramVarArgs.f(7, this.Tyg);
      }
      if (this.Tyh != null) {
        paramVarArgs.f(8, this.Tyh);
      }
      if (this.Tyi != null) {
        paramVarArgs.f(9, this.Tyi);
      }
      AppMethodBeat.o(250418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label776;
      }
    }
    label776:
    for (int i = g.a.a.b.b.a.g(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.Tyc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tyc);
      }
      paramInt = i;
      if (this.Tyd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tyd);
      }
      i = paramInt;
      if (this.Tye != null) {
        i = paramInt + g.a.a.a.oD(5, this.Tye.computeSize());
      }
      paramInt = i;
      if (this.Tyf != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tyf);
      }
      i = paramInt;
      if (this.Tyg != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tyg);
      }
      paramInt = i;
      if (this.Tyh != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tyh);
      }
      i = paramInt;
      if (this.Tyi != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Tyi);
      }
      AppMethodBeat.o(250418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cqr localcqr = (cqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250418);
          return -1;
        case 1: 
          localcqr.name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250418);
          return 0;
        case 2: 
          localcqr.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250418);
          return 0;
        case 3: 
          localcqr.Tyc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250418);
          return 0;
        case 4: 
          localcqr.Tyd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250418);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eys localeys = new eys();
            if ((localObject != null) && (localObject.length > 0)) {
              localeys.parseFrom((byte[])localObject);
            }
            localcqr.Tye = localeys;
            paramInt += 1;
          }
          AppMethodBeat.o(250418);
          return 0;
        case 6: 
          localcqr.Tyf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250418);
          return 0;
        case 7: 
          localcqr.Tyg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250418);
          return 0;
        case 8: 
          localcqr.Tyh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250418);
          return 0;
        }
        localcqr.Tyi = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(250418);
        return 0;
      }
      AppMethodBeat.o(250418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqr
 * JD-Core Version:    0.7.0.1
 */