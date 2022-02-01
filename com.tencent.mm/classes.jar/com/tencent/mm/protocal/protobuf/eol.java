package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eol
  extends com.tencent.mm.cd.a
{
  public int CreateTime;
  public String Id;
  public duy UqZ;
  public enl Ura;
  public String Urb;
  public int Urc;
  public int Urd;
  public String UserName;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.f(1, this.Id);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      paramVarArgs.aY(3, this.CreateTime);
      if (this.UqZ != null)
      {
        paramVarArgs.oE(4, this.UqZ.computeSize());
        this.UqZ.writeFields(paramVarArgs);
      }
      if (this.Ura != null)
      {
        paramVarArgs.oE(5, this.Ura.computeSize());
        this.Ura.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.timeStamp);
      if (this.Urb != null) {
        paramVarArgs.f(7, this.Urb);
      }
      paramVarArgs.aY(8, this.Urc);
      paramVarArgs.aY(9, this.Urd);
      AppMethodBeat.o(118475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = g.a.a.b.b.a.g(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UserName);
      }
      i += g.a.a.b.b.a.bM(3, this.CreateTime);
      paramInt = i;
      if (this.UqZ != null) {
        paramInt = i + g.a.a.a.oD(4, this.UqZ.computeSize());
      }
      i = paramInt;
      if (this.Ura != null) {
        i = paramInt + g.a.a.a.oD(5, this.Ura.computeSize());
      }
      i += g.a.a.b.b.a.p(6, this.timeStamp);
      paramInt = i;
      if (this.Urb != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Urb);
      }
      i = g.a.a.b.b.a.bM(8, this.Urc);
      int j = g.a.a.b.b.a.bM(9, this.Urd);
      AppMethodBeat.o(118475);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eol localeol = (eol)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118475);
          return -1;
        case 1: 
          localeol.Id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 2: 
          localeol.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 3: 
          localeol.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118475);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duy)localObject2).parseFrom((byte[])localObject1);
            }
            localeol.UqZ = ((duy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enl)localObject2).parseFrom((byte[])localObject1);
            }
            localeol.Ura = ((enl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 6: 
          localeol.timeStamp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(118475);
          return 0;
        case 7: 
          localeol.Urb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 8: 
          localeol.Urc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118475);
          return 0;
        }
        localeol.Urd = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(118475);
        return 0;
      }
      AppMethodBeat.o(118475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eol
 * JD-Core Version:    0.7.0.1
 */