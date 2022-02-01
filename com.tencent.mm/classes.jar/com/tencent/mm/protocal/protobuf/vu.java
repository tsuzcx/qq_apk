package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vu
  extends dyl
{
  public int Ilb;
  public String ImR;
  public String ImS;
  public String InV;
  public String RJf;
  public String ShY;
  public String ShZ;
  public int amount;
  public int channel;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91403);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RJf != null) {
        paramVarArgs.f(2, this.RJf);
      }
      if (this.InV != null) {
        paramVarArgs.f(3, this.InV);
      }
      paramVarArgs.aY(4, this.amount);
      if (this.ImS != null) {
        paramVarArgs.f(5, this.ImS);
      }
      if (this.ImR != null) {
        paramVarArgs.f(6, this.ImR);
      }
      paramVarArgs.aY(7, this.channel);
      paramVarArgs.aY(8, this.Ilb);
      if (this.ShY != null) {
        paramVarArgs.f(9, this.ShY);
      }
      if (this.ShZ != null) {
        paramVarArgs.f(10, this.ShZ);
      }
      AppMethodBeat.o(91403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label788;
      }
    }
    label788:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RJf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJf);
      }
      i = paramInt;
      if (this.InV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.InV);
      }
      i += g.a.a.b.b.a.bM(4, this.amount);
      paramInt = i;
      if (this.ImS != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ImS);
      }
      i = paramInt;
      if (this.ImR != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ImR);
      }
      i = i + g.a.a.b.b.a.bM(7, this.channel) + g.a.a.b.b.a.bM(8, this.Ilb);
      paramInt = i;
      if (this.ShY != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.ShY);
      }
      i = paramInt;
      if (this.ShZ != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.ShZ);
      }
      AppMethodBeat.o(91403);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        vu localvu = (vu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91403);
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
            localvu.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91403);
          return 0;
        case 2: 
          localvu.RJf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 3: 
          localvu.InV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 4: 
          localvu.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91403);
          return 0;
        case 5: 
          localvu.ImS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 6: 
          localvu.ImR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 7: 
          localvu.channel = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91403);
          return 0;
        case 8: 
          localvu.Ilb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91403);
          return 0;
        case 9: 
          localvu.ShY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91403);
          return 0;
        }
        localvu.ShZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91403);
        return 0;
      }
      AppMethodBeat.o(91403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vu
 * JD-Core Version:    0.7.0.1
 */