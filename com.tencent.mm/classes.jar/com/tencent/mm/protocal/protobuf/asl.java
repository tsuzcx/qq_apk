package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asl
  extends com.tencent.mm.bx.a
{
  public String OhO;
  public LinkedList<asm> YXg;
  public String ZCd;
  public long ZCe;
  public long ZCf;
  public String ZCg;
  public long ZCh;
  public String ZgS;
  
  public asl()
  {
    AppMethodBeat.i(91458);
    this.YXg = new LinkedList();
    AppMethodBeat.o(91458);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91459);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZCd != null) {
        paramVarArgs.g(1, this.ZCd);
      }
      paramVarArgs.e(2, 8, this.YXg);
      paramVarArgs.bv(3, this.ZCe);
      paramVarArgs.bv(4, this.ZCf);
      if (this.ZCg != null) {
        paramVarArgs.g(5, this.ZCg);
      }
      if (this.OhO != null) {
        paramVarArgs.g(6, this.OhO);
      }
      paramVarArgs.bv(7, this.ZCh);
      if (this.ZgS != null) {
        paramVarArgs.g(8, this.ZgS);
      }
      AppMethodBeat.o(91459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZCd == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZCd) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YXg) + i.a.a.b.b.a.q(3, this.ZCe) + i.a.a.b.b.a.q(4, this.ZCf);
      paramInt = i;
      if (this.ZCg != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZCg);
      }
      i = paramInt;
      if (this.OhO != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.OhO);
      }
      i += i.a.a.b.b.a.q(7, this.ZCh);
      paramInt = i;
      if (this.ZgS != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZgS);
      }
      AppMethodBeat.o(91459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YXg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        asl localasl = (asl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91459);
          return -1;
        case 1: 
          localasl.ZCd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            asm localasm = new asm();
            if ((localObject != null) && (localObject.length > 0)) {
              localasm.parseFrom((byte[])localObject);
            }
            localasl.YXg.add(localasm);
            paramInt += 1;
          }
          AppMethodBeat.o(91459);
          return 0;
        case 3: 
          localasl.ZCe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91459);
          return 0;
        case 4: 
          localasl.ZCf = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91459);
          return 0;
        case 5: 
          localasl.ZCg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 6: 
          localasl.OhO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 7: 
          localasl.ZCh = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91459);
          return 0;
        }
        localasl.ZgS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91459);
        return 0;
      }
      AppMethodBeat.o(91459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asl
 * JD-Core Version:    0.7.0.1
 */