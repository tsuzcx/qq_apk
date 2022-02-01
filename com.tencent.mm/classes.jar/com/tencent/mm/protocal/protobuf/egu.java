package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egu
  extends dyl
{
  public String Ujj;
  public float latitude;
  public float longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32438);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.i(2, this.longitude);
      paramVarArgs.i(3, this.latitude);
      paramVarArgs.aY(4, this.scene);
      if (this.Ujj != null) {
        paramVarArgs.f(5, this.Ujj);
      }
      AppMethodBeat.o(32438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label489;
      }
    }
    label489:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 4) + (g.a.a.b.b.a.gL(3) + 4) + g.a.a.b.b.a.bM(4, this.scene);
      paramInt = i;
      if (this.Ujj != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Ujj);
      }
      AppMethodBeat.o(32438);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        egu localegu = (egu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32438);
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
            localegu.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32438);
          return 0;
        case 2: 
          localegu.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(32438);
          return 0;
        case 3: 
          localegu.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(32438);
          return 0;
        case 4: 
          localegu.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32438);
          return 0;
        }
        localegu.Ujj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32438);
        return 0;
      }
      AppMethodBeat.o(32438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egu
 * JD-Core Version:    0.7.0.1
 */