package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class blp
  extends esc
{
  public b YJa;
  public int ZUG;
  public String wul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259170);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YJa != null) {
        paramVarArgs.d(2, this.YJa);
      }
      if (this.wul != null) {
        paramVarArgs.g(3, this.wul);
      }
      paramVarArgs.bS(4, this.ZUG);
      AppMethodBeat.o(259170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label448;
      }
    }
    label448:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.YJa);
      }
      i = paramInt;
      if (this.wul != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wul);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.ZUG);
      AppMethodBeat.o(259170);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259170);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        blp localblp = (blp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259170);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localblp.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259170);
          return 0;
        case 2: 
          localblp.YJa = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259170);
          return 0;
        case 3: 
          localblp.wul = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259170);
          return 0;
        }
        localblp.ZUG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259170);
        return 0;
      }
      AppMethodBeat.o(259170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blp
 * JD-Core Version:    0.7.0.1
 */