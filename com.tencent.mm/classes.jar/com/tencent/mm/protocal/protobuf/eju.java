package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eju
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public int Height;
  public String Md5;
  public eae UlK;
  public int Width;
  public int rWo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125784);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.f(1, this.Md5);
      }
      if (this.UlK != null)
      {
        paramVarArgs.oE(2, this.UlK.computeSize());
        this.UlK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Width);
      paramVarArgs.aY(4, this.Height);
      paramVarArgs.aY(5, this.rWo);
      if (this.CMB != null) {
        paramVarArgs.f(6, this.CMB);
      }
      AppMethodBeat.o(125784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = g.a.a.b.b.a.g(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UlK != null) {
        i = paramInt + g.a.a.a.oD(2, this.UlK.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.Width) + g.a.a.b.b.a.bM(4, this.Height) + g.a.a.b.b.a.bM(5, this.rWo);
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CMB);
      }
      AppMethodBeat.o(125784);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eju localeju = (eju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125784);
          return -1;
        case 1: 
          localeju.Md5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125784);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eae localeae = new eae();
            if ((localObject != null) && (localObject.length > 0)) {
              localeae.dd((byte[])localObject);
            }
            localeju.UlK = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(125784);
          return 0;
        case 3: 
          localeju.Width = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125784);
          return 0;
        case 4: 
          localeju.Height = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125784);
          return 0;
        case 5: 
          localeju.rWo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125784);
          return 0;
        }
        localeju.CMB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(125784);
        return 0;
      }
      AppMethodBeat.o(125784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eju
 * JD-Core Version:    0.7.0.1
 */