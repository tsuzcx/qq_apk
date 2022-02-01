package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abo
  extends dyl
{
  public String OmF;
  public String SnA;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72462);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.time_stamp);
      if (this.SnA != null) {
        paramVarArgs.f(3, this.SnA);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(72462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.time_stamp);
      paramInt = i;
      if (this.SnA != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SnA);
      }
      i = paramInt;
      if (this.OmF != null) {
        i = paramInt + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(72462);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        abo localabo = (abo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72462);
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
            localabo.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72462);
          return 0;
        case 2: 
          localabo.time_stamp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72462);
          return 0;
        case 3: 
          localabo.SnA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72462);
          return 0;
        }
        localabo.OmF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72462);
        return 0;
      }
      AppMethodBeat.o(72462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abo
 * JD-Core Version:    0.7.0.1
 */