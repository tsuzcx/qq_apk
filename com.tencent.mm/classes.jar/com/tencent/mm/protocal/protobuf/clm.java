package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clm
  extends com.tencent.mm.cd.a
{
  public cli Tta;
  public cli Ttb;
  public LinkedList<cll> Ttc;
  public String version;
  
  public clm()
  {
    AppMethodBeat.i(213875);
    this.Ttc = new LinkedList();
    AppMethodBeat.o(213875);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213878);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.version != null) {
        paramVarArgs.f(1, this.version);
      }
      if (this.Tta != null)
      {
        paramVarArgs.oE(2, this.Tta.computeSize());
        this.Tta.writeFields(paramVarArgs);
      }
      if (this.Ttb != null)
      {
        paramVarArgs.oE(3, this.Ttb.computeSize());
        this.Ttb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.Ttc);
      AppMethodBeat.o(213878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.version == null) {
        break label600;
      }
    }
    label600:
    for (int i = g.a.a.b.b.a.g(1, this.version) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tta != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tta.computeSize());
      }
      i = paramInt;
      if (this.Ttb != null) {
        i = paramInt + g.a.a.a.oD(3, this.Ttb.computeSize());
      }
      paramInt = g.a.a.a.c(4, 8, this.Ttc);
      AppMethodBeat.o(213878);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ttc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(213878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        clm localclm = (clm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(213878);
          return -1;
        case 1: 
          localclm.version = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(213878);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cli();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cli)localObject2).parseFrom((byte[])localObject1);
            }
            localclm.Tta = ((cli)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(213878);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cli();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cli)localObject2).parseFrom((byte[])localObject1);
            }
            localclm.Ttb = ((cli)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(213878);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cll();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cll)localObject2).parseFrom((byte[])localObject1);
          }
          localclm.Ttc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(213878);
        return 0;
      }
      AppMethodBeat.o(213878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clm
 * JD-Core Version:    0.7.0.1
 */