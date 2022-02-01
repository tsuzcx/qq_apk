package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkx
  extends com.tencent.mm.cd.a
{
  public String SVM;
  public int SVN;
  public String SVO;
  public FinderAuthInfo SVP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199018);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SVM != null) {
        paramVarArgs.f(1, this.SVM);
      }
      paramVarArgs.aY(2, this.SVN);
      if (this.SVO != null) {
        paramVarArgs.f(3, this.SVO);
      }
      if (this.SVP != null)
      {
        paramVarArgs.oE(4, this.SVP.computeSize());
        this.SVP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(199018);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SVM == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.b.b.a.g(1, this.SVM) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SVN);
      paramInt = i;
      if (this.SVO != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SVO);
      }
      i = paramInt;
      if (this.SVP != null) {
        i = paramInt + g.a.a.a.oD(4, this.SVP.computeSize());
      }
      AppMethodBeat.o(199018);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199018);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bkx localbkx = (bkx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199018);
          return -1;
        case 1: 
          localbkx.SVM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(199018);
          return 0;
        case 2: 
          localbkx.SVN = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(199018);
          return 0;
        case 3: 
          localbkx.SVO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(199018);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderAuthInfo.parseFrom((byte[])localObject);
          }
          localbkx.SVP = localFinderAuthInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(199018);
        return 0;
      }
      AppMethodBeat.o(199018);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkx
 * JD-Core Version:    0.7.0.1
 */