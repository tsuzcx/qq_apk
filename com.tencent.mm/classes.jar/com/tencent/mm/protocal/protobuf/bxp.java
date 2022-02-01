package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxp
  extends dyl
{
  public int Height;
  public float ScO;
  public float ScP;
  public int The;
  public int Thf;
  public int Width;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56247);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.i(2, this.ScO);
      paramVarArgs.i(3, this.ScP);
      paramVarArgs.aY(4, this.Width);
      paramVarArgs.aY(5, this.Height);
      if (this.vhq != null) {
        paramVarArgs.f(6, this.vhq);
      }
      paramVarArgs.aY(7, this.The);
      paramVarArgs.aY(8, this.Thf);
      AppMethodBeat.o(56247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 4) + (g.a.a.b.b.a.gL(3) + 4) + g.a.a.b.b.a.bM(4, this.Width) + g.a.a.b.b.a.bM(5, this.Height);
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.vhq);
      }
      i = g.a.a.b.b.a.bM(7, this.The);
      int j = g.a.a.b.b.a.bM(8, this.Thf);
      AppMethodBeat.o(56247);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(56247);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bxp localbxp = (bxp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56247);
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
            localbxp.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(56247);
          return 0;
        case 2: 
          localbxp.ScO = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(56247);
          return 0;
        case 3: 
          localbxp.ScP = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(56247);
          return 0;
        case 4: 
          localbxp.Width = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(56247);
          return 0;
        case 5: 
          localbxp.Height = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(56247);
          return 0;
        case 6: 
          localbxp.vhq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(56247);
          return 0;
        case 7: 
          localbxp.The = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(56247);
          return 0;
        }
        localbxp.Thf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(56247);
        return 0;
      }
      AppMethodBeat.o(56247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxp
 * JD-Core Version:    0.7.0.1
 */