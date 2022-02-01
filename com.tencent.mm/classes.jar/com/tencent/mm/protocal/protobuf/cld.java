package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cld
  extends com.tencent.mm.cd.a
{
  public cle TsH;
  public b TsI;
  public b TsJ;
  public acx TsK;
  public int TsL;
  public int ddx;
  public String md5;
  public String name;
  public String smT;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209705);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      paramVarArgs.aY(2, this.version);
      if (this.TsH != null)
      {
        paramVarArgs.oE(3, this.TsH.computeSize());
        this.TsH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.ddx);
      if (this.TsI != null) {
        paramVarArgs.c(5, this.TsI);
      }
      if (this.smT != null) {
        paramVarArgs.f(6, this.smT);
      }
      if (this.TsJ != null) {
        paramVarArgs.c(7, this.TsJ);
      }
      if (this.md5 != null) {
        paramVarArgs.f(8, this.md5);
      }
      if (this.TsK != null)
      {
        paramVarArgs.oE(9, this.TsK.computeSize());
        this.TsK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.TsL);
      AppMethodBeat.o(209705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = g.a.a.b.b.a.g(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.version);
      paramInt = i;
      if (this.TsH != null) {
        paramInt = i + g.a.a.a.oD(3, this.TsH.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.ddx);
      paramInt = i;
      if (this.TsI != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.TsI);
      }
      i = paramInt;
      if (this.smT != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.smT);
      }
      paramInt = i;
      if (this.TsJ != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.TsJ);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.md5);
      }
      paramInt = i;
      if (this.TsK != null) {
        paramInt = i + g.a.a.a.oD(9, this.TsK.computeSize());
      }
      i = g.a.a.b.b.a.bM(10, this.TsL);
      AppMethodBeat.o(209705);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(209705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cld localcld = (cld)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209705);
          return -1;
        case 1: 
          localcld.name = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209705);
          return 0;
        case 2: 
          localcld.version = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(209705);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cle();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cle)localObject2).parseFrom((byte[])localObject1);
            }
            localcld.TsH = ((cle)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(209705);
          return 0;
        case 4: 
          localcld.ddx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(209705);
          return 0;
        case 5: 
          localcld.TsI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(209705);
          return 0;
        case 6: 
          localcld.smT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209705);
          return 0;
        case 7: 
          localcld.TsJ = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(209705);
          return 0;
        case 8: 
          localcld.md5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209705);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acx)localObject2).parseFrom((byte[])localObject1);
            }
            localcld.TsK = ((acx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(209705);
          return 0;
        }
        localcld.TsL = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(209705);
        return 0;
      }
      AppMethodBeat.o(209705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cld
 * JD-Core Version:    0.7.0.1
 */