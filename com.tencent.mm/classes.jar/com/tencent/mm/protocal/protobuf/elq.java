package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elq
  extends dyl
{
  public String Lwz;
  public int SZz;
  public int UnL;
  public String ktM;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91696);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.scene);
      if (this.Lwz != null) {
        paramVarArgs.f(3, this.Lwz);
      }
      if (this.ktM != null) {
        paramVarArgs.f(4, this.ktM);
      }
      paramVarArgs.aY(5, this.UnL);
      paramVarArgs.aY(6, this.SZz);
      AppMethodBeat.o(91696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label544;
      }
    }
    label544:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.scene);
      paramInt = i;
      if (this.Lwz != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Lwz);
      }
      i = paramInt;
      if (this.ktM != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ktM);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.UnL);
      int j = g.a.a.b.b.a.bM(6, this.SZz);
      AppMethodBeat.o(91696);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        elq localelq = (elq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91696);
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
            localelq.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91696);
          return 0;
        case 2: 
          localelq.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91696);
          return 0;
        case 3: 
          localelq.Lwz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91696);
          return 0;
        case 4: 
          localelq.ktM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91696);
          return 0;
        case 5: 
          localelq.UnL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91696);
          return 0;
        }
        localelq.SZz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91696);
        return 0;
      }
      AppMethodBeat.o(91696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elq
 * JD-Core Version:    0.7.0.1
 */