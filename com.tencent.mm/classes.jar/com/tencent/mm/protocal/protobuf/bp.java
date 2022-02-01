package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bp
  extends com.tencent.mm.cd.a
{
  public String CNU;
  public String CQz;
  public String RGH;
  public String RGI;
  public String RGJ;
  public String RGK;
  public String RGL;
  public String RGM;
  public fqj RGN;
  public String RGO;
  public String jUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152478);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jUi != null) {
        paramVarArgs.f(1, this.jUi);
      }
      if (this.RGH != null) {
        paramVarArgs.f(2, this.RGH);
      }
      if (this.RGI != null) {
        paramVarArgs.f(3, this.RGI);
      }
      if (this.CNU != null) {
        paramVarArgs.f(4, this.CNU);
      }
      if (this.CQz != null) {
        paramVarArgs.f(5, this.CQz);
      }
      if (this.RGJ != null) {
        paramVarArgs.f(6, this.RGJ);
      }
      if (this.RGK != null) {
        paramVarArgs.f(7, this.RGK);
      }
      if (this.RGL != null) {
        paramVarArgs.f(8, this.RGL);
      }
      if (this.RGM != null) {
        paramVarArgs.f(9, this.RGM);
      }
      if (this.RGN != null)
      {
        paramVarArgs.oE(10, this.RGN.computeSize());
        this.RGN.writeFields(paramVarArgs);
      }
      if (this.RGO != null) {
        paramVarArgs.f(11, this.RGO);
      }
      AppMethodBeat.o(152478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jUi == null) {
        break label900;
      }
    }
    label900:
    for (int i = g.a.a.b.b.a.g(1, this.jUi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RGH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RGH);
      }
      i = paramInt;
      if (this.RGI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RGI);
      }
      paramInt = i;
      if (this.CNU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CNU);
      }
      i = paramInt;
      if (this.CQz != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CQz);
      }
      paramInt = i;
      if (this.RGJ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RGJ);
      }
      i = paramInt;
      if (this.RGK != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RGK);
      }
      paramInt = i;
      if (this.RGL != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RGL);
      }
      i = paramInt;
      if (this.RGM != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RGM);
      }
      paramInt = i;
      if (this.RGN != null) {
        paramInt = i + g.a.a.a.oD(10, this.RGN.computeSize());
      }
      i = paramInt;
      if (this.RGO != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.RGO);
      }
      AppMethodBeat.o(152478);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bp localbp = (bp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152478);
          return -1;
        case 1: 
          localbp.jUi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 2: 
          localbp.RGH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 3: 
          localbp.RGI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 4: 
          localbp.CNU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 5: 
          localbp.CQz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 6: 
          localbp.RGJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 7: 
          localbp.RGK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 8: 
          localbp.RGL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 9: 
          localbp.RGM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fqj localfqj = new fqj();
            if ((localObject != null) && (localObject.length > 0)) {
              localfqj.parseFrom((byte[])localObject);
            }
            localbp.RGN = localfqj;
            paramInt += 1;
          }
          AppMethodBeat.o(152478);
          return 0;
        }
        localbp.RGO = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152478);
        return 0;
      }
      AppMethodBeat.o(152478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bp
 * JD-Core Version:    0.7.0.1
 */