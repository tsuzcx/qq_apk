package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class b
  extends com.tencent.mm.bx.a
{
  public int ToA;
  public String ToB;
  public String ToC;
  public String Tou;
  public String Tov;
  public k Tow;
  public String Tox;
  public boolean Toy;
  public long Toz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290037);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Tov != null) {
        paramVarArgs.g(1, this.Tov);
      }
      if (this.Tow != null)
      {
        paramVarArgs.qD(2, this.Tow.computeSize());
        this.Tow.writeFields(paramVarArgs);
      }
      if (this.Tox != null) {
        paramVarArgs.g(3, this.Tox);
      }
      paramVarArgs.di(4, this.Toy);
      paramVarArgs.bv(5, this.Toz);
      paramVarArgs.bS(6, this.ToA);
      if (this.ToB != null) {
        paramVarArgs.g(7, this.ToB);
      }
      if (this.ToC != null) {
        paramVarArgs.g(8, this.ToC);
      }
      if (this.Tou != null) {
        paramVarArgs.g(9, this.Tou);
      }
      AppMethodBeat.o(290037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tov == null) {
        break label720;
      }
    }
    label720:
    for (int i = i.a.a.b.b.a.h(1, this.Tov) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tow != null) {
        paramInt = i + i.a.a.a.qC(2, this.Tow.computeSize());
      }
      i = paramInt;
      if (this.Tox != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Tox);
      }
      i = i + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.b.b.a.q(5, this.Toz) + i.a.a.b.b.a.cJ(6, this.ToA);
      paramInt = i;
      if (this.ToB != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ToB);
      }
      i = paramInt;
      if (this.ToC != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.ToC);
      }
      paramInt = i;
      if (this.Tou != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Tou);
      }
      AppMethodBeat.o(290037);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(290037);
          return -1;
        case 1: 
          localb.Tov = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290037);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            k localk = new k();
            if ((localObject != null) && (localObject.length > 0)) {
              localk.parseFrom((byte[])localObject);
            }
            localb.Tow = localk;
            paramInt += 1;
          }
          AppMethodBeat.o(290037);
          return 0;
        case 3: 
          localb.Tox = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290037);
          return 0;
        case 4: 
          localb.Toy = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(290037);
          return 0;
        case 5: 
          localb.Toz = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(290037);
          return 0;
        case 6: 
          localb.ToA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(290037);
          return 0;
        case 7: 
          localb.ToB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290037);
          return 0;
        case 8: 
          localb.ToC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290037);
          return 0;
        }
        localb.Tou = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(290037);
        return 0;
      }
      AppMethodBeat.o(290037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.b
 * JD-Core Version:    0.7.0.1
 */