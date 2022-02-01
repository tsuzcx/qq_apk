package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eui
  extends dyy
{
  public String UvR;
  public int UvY;
  public LinkedList<coi> UvZ;
  public coi Uwa;
  public String subtitle;
  public String title;
  public int tqa;
  public String tqb;
  
  public eui()
  {
    AppMethodBeat.i(72603);
    this.UvZ = new LinkedList();
    AppMethodBeat.o(72603);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72604);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.title != null) {
        paramVarArgs.f(4, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.f(5, this.subtitle);
      }
      paramVarArgs.aY(6, this.UvY);
      paramVarArgs.e(7, 8, this.UvZ);
      if (this.Uwa != null)
      {
        paramVarArgs.oE(8, this.Uwa.computeSize());
        this.Uwa.writeFields(paramVarArgs);
      }
      if (this.UvR != null) {
        paramVarArgs.f(9, this.UvR);
      }
      AppMethodBeat.o(72604);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label872;
      }
    }
    label872:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.title);
      }
      paramInt = i;
      if (this.subtitle != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.subtitle);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.UvY) + g.a.a.a.c(7, 8, this.UvZ);
      paramInt = i;
      if (this.Uwa != null) {
        paramInt = i + g.a.a.a.oD(8, this.Uwa.computeSize());
      }
      i = paramInt;
      if (this.UvR != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UvR);
      }
      AppMethodBeat.o(72604);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UvZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72604);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eui localeui = (eui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72604);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localeui.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 2: 
          localeui.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72604);
          return 0;
        case 3: 
          localeui.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 4: 
          localeui.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 5: 
          localeui.subtitle = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 6: 
          localeui.UvY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72604);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new coi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((coi)localObject2).parseFrom((byte[])localObject1);
            }
            localeui.UvZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new coi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((coi)localObject2).parseFrom((byte[])localObject1);
            }
            localeui.Uwa = ((coi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        }
        localeui.UvR = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72604);
        return 0;
      }
      AppMethodBeat.o(72604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eui
 * JD-Core Version:    0.7.0.1
 */