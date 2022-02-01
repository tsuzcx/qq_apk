package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwd
  extends dyl
{
  public String SWw;
  public cvz TFa;
  public String TFb;
  public int scene;
  public String username;
  public long xcd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203624);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TFa != null)
      {
        paramVarArgs.oE(2, this.TFa.computeSize());
        this.TFa.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(3, this.xcd);
      if (this.username != null) {
        paramVarArgs.f(4, this.username);
      }
      if (this.SWw != null) {
        paramVarArgs.f(5, this.SWw);
      }
      if (this.TFb != null) {
        paramVarArgs.f(6, this.TFb);
      }
      paramVarArgs.aY(7, this.scene);
      AppMethodBeat.o(203624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TFa != null) {
        i = paramInt + g.a.a.a.oD(2, this.TFa.computeSize());
      }
      i += g.a.a.b.b.a.p(3, this.xcd);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.username);
      }
      i = paramInt;
      if (this.SWw != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SWw);
      }
      paramInt = i;
      if (this.TFb != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TFb);
      }
      i = g.a.a.b.b.a.bM(7, this.scene);
      AppMethodBeat.o(203624);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cwd localcwd = (cwd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203624);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcwd.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203624);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cvz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cvz)localObject2).parseFrom((byte[])localObject1);
            }
            localcwd.TFa = ((cvz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203624);
          return 0;
        case 3: 
          localcwd.xcd = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(203624);
          return 0;
        case 4: 
          localcwd.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203624);
          return 0;
        case 5: 
          localcwd.SWw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203624);
          return 0;
        case 6: 
          localcwd.TFb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(203624);
          return 0;
        }
        localcwd.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(203624);
        return 0;
      }
      AppMethodBeat.o(203624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwd
 * JD-Core Version:    0.7.0.1
 */