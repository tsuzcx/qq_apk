package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cmf
  extends com.tencent.mm.cd.a
{
  public String RQx;
  public String Sqe;
  public eaf TtX;
  public int TtY;
  public String UserName;
  public int vhf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155423);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.vhf);
      if (this.TtX != null)
      {
        paramVarArgs.oE(2, this.TtX.computeSize());
        this.TtX.writeFields(paramVarArgs);
      }
      if (this.RQx != null) {
        paramVarArgs.f(3, this.RQx);
      }
      if (this.Sqe != null) {
        paramVarArgs.f(4, this.Sqe);
      }
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      paramVarArgs.aY(6, this.TtY);
      AppMethodBeat.o(155423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.vhf) + 0;
      paramInt = i;
      if (this.TtX != null) {
        paramInt = i + g.a.a.a.oD(2, this.TtX.computeSize());
      }
      i = paramInt;
      if (this.RQx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RQx);
      }
      paramInt = i;
      if (this.Sqe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sqe);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UserName);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.TtY);
      AppMethodBeat.o(155423);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      AppMethodBeat.o(155423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      cmf localcmf = (cmf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155423);
        return -1;
      case 1: 
        localcmf.vhf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(155423);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eaf localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localcmf.TtX = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(155423);
        return 0;
      case 3: 
        localcmf.RQx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 4: 
        localcmf.Sqe = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 5: 
        localcmf.UserName = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155423);
        return 0;
      }
      localcmf.TtY = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(155423);
      return 0;
    }
    AppMethodBeat.o(155423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmf
 * JD-Core Version:    0.7.0.1
 */