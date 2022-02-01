package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xh
  extends dyl
{
  public String RGZ;
  public String Sjx;
  public boolean Sjy;
  public int Sjz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RGZ != null) {
        paramVarArgs.f(2, this.RGZ);
      }
      if (this.Sjx != null) {
        paramVarArgs.f(3, this.Sjx);
      }
      paramVarArgs.co(4, this.Sjy);
      paramVarArgs.aY(5, this.Sjz);
      AppMethodBeat.o(125716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RGZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RGZ);
      }
      i = paramInt;
      if (this.Sjx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sjx);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      int j = g.a.a.b.b.a.bM(5, this.Sjz);
      AppMethodBeat.o(125716);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        xh localxh = (xh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125716);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localxh.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(125716);
          return 0;
        case 2: 
          localxh.RGZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 3: 
          localxh.Sjx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 4: 
          localxh.Sjy = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(125716);
          return 0;
        }
        localxh.Sjz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125716);
        return 0;
      }
      AppMethodBeat.o(125716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xh
 * JD-Core Version:    0.7.0.1
 */